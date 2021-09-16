package kenservlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegExServlet
 */
@WebServlet("/regex")
public class RegExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエスト処理
		request.setAttribute("message", "入力してください");
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/regexInput.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レスポンス処理
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("zip");
		String regex = "^\\d{3}-\\d{4}$";
		
		String message = "";
		if(param != null && !param.isEmpty()) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(param);
			if( matcher.matches()) {
				message = "登録完了しました";
			}else {
				message = "不適切な入力です";
			}
		}else {
			message = "入力は必須です";
		}
		
		request.setAttribute("message", message);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/regexInput.jsp");
		rd.forward(request, response);
	}

}
