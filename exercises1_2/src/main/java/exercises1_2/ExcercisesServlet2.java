package exercises1_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcercisesServlet2
 */
@WebServlet("/exercises2")
public class ExcercisesServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエスト処理

		// 不正なページからアクセスがあった場合
		String url = "http://localhost:8080/exercises1_2/exercises_page2.html";
		String referer = request.getHeader("Referer");

		if( referer == null || !referer.equals(url)) {
			response.setStatus(HttpServletResponse.SC_FOUND);
			response.setHeader("Location", url);
			System.out.println("リダイレクトしました");
			return;
		}

		// 正しいぺページからアクセスがあった場合
		request.setCharacterEncoding("UTF-8");
		String value1 = request.getParameter("value1");
		String value2 = request.getParameter("value2");

		// 結果表示文字列
		String disp;

		// 入力文字のどちらかが空の場合
		if( value1.isEmpty() || value2.isEmpty() ) {
			disp = "両方のテキストボックスに値を入れて下さい。";

		}else {

			try {
				int intValue1 = Integer.parseInt(value1);
				int intValue2 = Integer.parseInt(value2);

				// 合計結果表示文字列
				disp = intValue1 + "足す" + intValue2 + "は" + (intValue1 + intValue2) + "です。";

			}catch( NumberFormatException e ) {
				// 数字→数値に変換できなかった場合
				disp = "値が不正です。数値を入力して下さい";

			}

		}

		// レスポンス処理
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ja\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>計算結果を表示</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<header><h1>計算結果を表示</h1>");
		out.println("<main>");
		out.println("<hr>");
		out.println("<p>" + disp + "</p>");
		out.println("</main>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
