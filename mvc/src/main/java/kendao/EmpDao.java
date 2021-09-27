package kendao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kenmodel.EmpBean;



public class EmpDao {
	private Connection connection;

	public EmpDao() throws ClassNotFoundException, SQLException {
		// ドライバを指定
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/java_web_system?useSSL=false";
		String user = "root";
		String password = "root";

		// ドライバーとDB接続情報を使ってDBに接続する
		connection = DriverManager.getConnection(url, user, password);

	}

	public void close() {
		if( connection != null ) {
			try {
				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public EmpBean getEmpDataById( int empId ) throws SQLException {
		EmpBean bean = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;

		try {
			String sql = "select * from employee where employee_id = ?";

			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, empId);
			rs = pstatement.executeQuery();

			if( rs.next() ) {
				bean = new EmpBean();
				bean.setId( rs.getInt("employee_id") );
				bean.setName( rs.getString("employee_name") );
				bean.setAddress( rs.getString("employee_address") );
				bean.setAge( rs.getInt( "employee_age") );
				bean.setMail( rs.getString("employee_mail") );
			}
			rs.close();

		} finally {
			pstatement.close();
		}
		return bean;
	}






}
