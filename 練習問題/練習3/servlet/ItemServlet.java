package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//商品一覧
	ArrayList<Item> items  = new ArrayList<>();

	/**
	 * Servletの起動時に実行されるメソッド
	 */
	@Override
	public void init() throws ServletException {
		items.add( new Item(1, "ストロベリーショート2個", 550, "口どけのよいホイップクリームを使用し、あまおう苺を使用した甘酸っぱいジャムをサンド", "short.jpg" ) );
		items.add( new Item(2, "マカロン5個入り", 800, "あまおう苺2個・バニラ2個・ショコラ1個のマカロンの詰め合わせ","macaron.jpg" ) );
		items.add( new Item(3, "パイコロネショコラ", 200, "サクサクパイで心躍る♪生チョコのような口どけも楽しめるパイコロネ", "corone.jpg" ) );
		items.add( new Item(4, "ふわとろオムレツサンド", 320, "生クリームを使用しまろやかに仕上げたふわとろオムレツにベーコン、ケチャップを合わせました", "omu.jpg" ) );
		items.add( new Item(5, "ブランのイングリッシュマフィン", 270, "糖質を気にする方におススメ！ブラン粉を使用したブラン入りイングリッシュマフィン", "mafin.jpg" ) );

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//商品情報一覧をリクエストにセットしておく
		request.setAttribute("items", items);

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/item.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
