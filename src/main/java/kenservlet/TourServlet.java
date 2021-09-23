package kenservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kenmodel.TourBean;

/**
 * Servlet implementation class TourServlet
 */
@WebServlet("/tour")
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 商品情報を作成しオブジェクトtoursにセットする
		request.setAttribute("tours", createTours());
		
		// /top.jspにフォワードする
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/top.jsp");
		dispatcher.forward(request, response);
		
	}

	private List<TourBean> createTours() {
		List<TourBean> tours = new ArrayList<>();
		
		TourBean tour = new TourBean();
		tour.setTourId("001");
		tour.setTourName("世界一透明な海でお魚さんと追いかけっこ");
		tour.setPlace("沖縄");
		tour.setPrice(53000);
		tours.add(tour);
		
		tour = new TourBean();
		tour.setTourId("002");
		tour.setTourName("くいだおれの街大阪！日本の台所満喫ツアー");
		tour.setPlace("大阪");
		tour.setPrice(10000);
		tours.add(tour);
		
		tour = new TourBean();
		tour.setTourId("003");
		tour.setTourName("大牧場え自家製チーズ作り体験！");
		tour.setPlace("北海道");
		tour.setPrice(32000);
		tours.add(tour);
		
		return tours;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String btn = request.getParameter("btn");
		TourBean tour = null;
		HttpSession session = request.getSession(true);
		String jsp = null;
		
		if( btn.equals("選択") ) {
			String tourId = request.getParameter("tourId");
			tour = serchTour( createTours(), tourId );	// tourはNULLになる可能性あり？
			session.setAttribute("tour", tour);
			jsp = "/number.jsp";
			
		}else if( btn.equals("試算") ) {
			String adult = request.getParameter("adult");
			String child = request.getParameter("child");
			
			tour = (TourBean)session.getAttribute("tour");
			
			tour.setNumAdult(Integer.parseInt(adult));
			tour.setNumChild(Integer.parseInt(child));
			
			jsp = "/calc.jsp";
			
		}else {
			session.invalidate();
			request.setAttribute("tours", createTours());
			jsp = "/top.jsp";
		}
		
		// /number.jspにフォワードする
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher( jsp );
		dispatcher.forward(request, response);
	}

	private TourBean serchTour(List<TourBean> tours, String tourId) {
		TourBean tour = null;
		for( TourBean t : tours ) {
			if( t.getTourId().equals(tourId) ) {
				tour = t;
				break;
			}
		}
		return tour;
	}

}
