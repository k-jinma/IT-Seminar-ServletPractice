package exercise1_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExercisesServlet1
 */
@WebServlet("/exercises1")
public class ExercisesServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエスト処理
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("value");
		String disp;
		if( param != null ) {	// パラメータが存在するかのチェック
			if( !param.isEmpty() ) {	// 未入力チェック      param.length() != 0
				disp = param + "さん、こんにちは！";
			}else {
				disp = "テキストボックスに値を入力してください。";
			}
		}else {
			disp = "<a href=\"exercises_page1.html\">トップページに戻ってください</a>" ;
		}
		// レスポンス処理
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>ごあいさつ</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<header><h1>ごあいさつ</h1>");
		out.println("<main>");
		out.println("<hr>");
		out.println("<p>" + disp + "</p>");
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
