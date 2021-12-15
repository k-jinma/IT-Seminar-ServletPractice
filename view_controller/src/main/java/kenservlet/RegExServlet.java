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

		request.setAttribute("message", "入力してください");

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/regexInput.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		String param = request.getParameter("zip");
		String param2 = request.getParameter("tel");

		// ^ここからはじまり $ここで終わる　という意味
		String regex = "^\\d{3}-\\d{4}$";	// ^[0-9]{3}-[0-9]{4}$
		String regex2 = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$";

		String message = "";

		//不正アクセスでなく、空欄でなければ
		if( param != null && !param.isEmpty() ) {

			//検証する
			if( match(regex , param) && match(regex2, param2) ) {
				message = "登録完了しました";

			}else {
				message = "不適切な入力です";
			}
		}else {
			message = "入力は必須です";
		}

		request.setAttribute("message", message);

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/regexInput.jsp");
		rd.forward(request, response);
	}


	/**
	 * パターンマッチを判定するメソッドを自作
	 * 引数: regex 正規表現文字列
	 * 引数: param 検証文字列
	 * 戻り値： パターンに一致していればtrue、不一致はfalseを返す
	 */
	public boolean match( String regex, String param ) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(param);

		if( matcher.matches() ) {
			return true;

		}else {
			return false;
		}

	}

}
