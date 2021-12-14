package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String[] userid = {"jinma"};	// 登録済みユーザー名
	private String[] password = {"pjinma"};	// 登録済パスワード

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");	//	フォームからユーザ名を取得する
		String pass = request.getParameter("password");	// フォームからパスワードを取得する
		boolean login = false;	// ログインの成功状態を管理する変数

		String err_msg1;	//ユーザー名のエラー文字列
		String err_msg2;	//パスワードのエラー文字列

		// ユーザ名が入力されているかどうかをチェックする
		if( name.isEmpty() ) {
			err_msg1 = "ユーザー名が未入力です";
			request.setAttribute("err_msg1", err_msg1);
		}
		// パスワードが入力されているかどうかをチェックする
		if( pass.isEmpty() ) {
			err_msg2 = "パスワードが未入力です";
			request.setAttribute("err_msg2", err_msg2);
		}

		// 直接URLアクセスされていなければ
		if( name != null || pass != null ){
			//ユーザー名とパスワードが一致しているか確認する
			for( int i = 0; i < userid.length; i++ ){
				if( name.equals( userid[i]) && pass.equals( password[i] ) ){
					// ユーザー名とパスワードが一致していれば tureとする
					login = true;
					// ログイン後の画面で表示するユーザー名
					request.setAttribute("name", userid[i] );
					break;
				}
			}
		}

		// ユーザー名とパスワードが一致しているとき
		if( login == true ) {
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);

		// ユーザー名とパスワードが不一致のとき
		}else {
			String err = "ユーザー名かパスワードが間違っています。";
			request.setAttribute("err", err);

			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
