package ken.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ken.bean.Item;

public class SearchDAO {
	private Connection connection;
	private PreparedStatement p_statement_selectItems_no_key;
	private PreparedStatement p_statement_selectItems;
	
	public SearchDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/latte_station?useSSL=false";
		String user = "root";
		String password = "jinma0807";
		connection = DriverManager.getConnection(url, user, password);
		
		String sql1 = "select * from latte_station.item where genre_id = ?";
		String sql2 = "select * from latte_station.item where genre_id = ? and (item_name like ? or artist like ?)";
		
		p_statement_selectItems_no_key = connection.prepareStatement(sql1);
		p_statement_selectItems = connection.prepareStatement(sql2);
	}
	
	public ArrayList<Item> search_table( String key, String genre ) throws SQLException{
		
		ResultSet rs_items = null;

		if( !key.equals("") ) {
			p_statement_selectItems.setString(1, genre);
			p_statement_selectItems.setString(2, "%" + key + "%");
			p_statement_selectItems.setString(3, "%" + key + "%");
			rs_items = p_statement_selectItems.executeQuery();
		
		}else {
			p_statement_selectItems_no_key.setString(1, genre);
			rs_items = p_statement_selectItems_no_key.executeQuery();
		}
		
		ArrayList<Item> list = new ArrayList<>();
		while( rs_items.next() ) {
			Item item = new Item();
			item.setItemId( rs_items.getInt("item_id") );
			item.setItemName(rs_items.getString("item_name") );
			item.setItemArtist( rs_items.getString("artist"));
			item.setItemPrice( rs_items.getInt("price") );
			item.setItemImage( rs_items.getString("item_img") );
			
			list.add(item);
		}

		if( rs_items != null ) {
			rs_items.close();
		}
		if( connection != null ) {
			connection.close();
		}		
		return list;
	}
}
