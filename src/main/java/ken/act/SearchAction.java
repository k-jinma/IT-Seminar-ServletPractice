package ken.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ken.bean.Item;
import ken.dao.SearchDAO;

public class SearchAction extends Action{

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		String keyword = request.getParameter("keyword");
		String genre = request.getParameter("genre");
		
		SearchDAO searchDao = new SearchDAO();
		ArrayList<Item> items = searchDao.search_table(keyword, genre);
		
		HttpSession session = request.getSession();
		session.setAttribute("table_items", items);
		if( items.size() == 0 ) {
			session.setAttribute("no_item", "");
			session.setAttribute("message", "該当する商品はありません。");
		}
		
		return "/top.jsp";
	}

	
}
