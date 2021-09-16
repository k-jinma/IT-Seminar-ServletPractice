package kenservlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "お名前を入力して「Cookieを発行する」を押してください。";
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		
		if( cookies != null ) {
			for( Cookie cookie : cookies ) {	// クライアントからの全てのクッキーを取得する
				if(cookie.getName().equals("cname")) {	// "cname"というクッキー名が見つかれば
					cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");	// デコードする
					message = "再度、お名前を入力して「Cookieを発行する」を押すと、新しい名前を登録できます。";
				}
			}
		}
		// メッセージとデコードしたクッキー情報をセットする
		request.setAttribute("message", message);
		request.setAttribute("cookieValue", cookieValue);
		
		// JSPに転送する（ページ遷移する）
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/getcookie.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String message;
		
		if(name != null && !name.isEmpty()) {
			String encName = URLEncoder.encode(name, "UTF-8");	// お名前をエンコードする
			Cookie cookie = new Cookie("cname", encName);	// クッキーを生成して、お名前を"cname"というクッキー名で発行する
			cookie.setMaxAge(60*60*24*7);	// クッキーの生存期間を設定する	
			response.addCookie(cookie);	// クッキーをレスポンスする
			message = "戻って確認して下さい";
			
		}else {
			name = null;
			message = "戻ってお名前を入力して下さい。";
		}
		
		request.setAttribute("name", name);
		request.setAttribute("message", message);
		
		// JSPに転送する（ページ遷移する）
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/postcookie.jsp");
		rd.forward(request, response);
	}

}
