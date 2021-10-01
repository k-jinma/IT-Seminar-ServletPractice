package ken.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ken.bean.Item;

public class CheckAction extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if( session == null ) {
			return "/irregular_error.jsp";
		}
		
		ArrayList<Item> items = (ArrayList<Item>) session.getAttribute("cart");
		if( items == null || items.size() == 0 ) {
			return "/error.jsp";
		}else {
			return "/cart.jsp";
		}
		
	}

}
