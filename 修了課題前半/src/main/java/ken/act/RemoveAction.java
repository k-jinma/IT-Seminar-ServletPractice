package ken.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ken.bean.Item;

public class RemoveAction extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if( session == null ) {
			return "/irregular_error.jsp";
		}
		
		ArrayList<Item> items = (ArrayList<Item>) session.getAttribute("cart");
		String param = request.getParameter("remove");
		items.remove(Integer.parseInt(param));
		
		return "/cart.jsp";
	}

}
