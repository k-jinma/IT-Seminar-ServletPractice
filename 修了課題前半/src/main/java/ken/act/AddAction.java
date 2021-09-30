package ken.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ken.bean.Item;

public class AddAction extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String artist = request.getParameter("artist");
		String price = request.getParameter("price");
		
		Item item = new Item();
		item.setItemId(Integer.parseInt(id) );
		item.setItemName(name);
		item.setItemArtist(artist);
		item.setItemPrice(Integer.parseInt(price));
		
		HttpSession session = request.getSession();
		ArrayList<Item> items =  (ArrayList<Item>) session.getAttribute("cart");
		items.add(item);
		
		session.setAttribute("cart", items);
		
		return "/top.jsp";
	}

}
