package exercises3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeafoodFormServlet
 */
@WebServlet("/form")
public class SeafoodFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// セッションがあればセッションを用意し、なければ用意せずNULLとしておく
		HttpSession session = request.getSession(false);
		ArrayList<String> cart = null;
		
		// セッションがあれば
		if( session != null ) {
			cart = (ArrayList<String>)session.getAttribute("cart");
		}
		
		String message ;
		// カートがあれば
		if( cart != null && !cart.isEmpty() ) {
			message = "カートに" + cart.size() + "個の商品が入っています";
		}else {
			message = "商品を選んでください";
		}
		// セッションがあればカートの情報を表示、なければ商品を選んでくださいと表示させる用
		request.setAttribute(message, message);
		
		// JSPへの転送
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/seafood_form.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
