package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.LoginInfo;

public class CancelDao {
	
	public CancelDao(String name) {
		
		
		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String pass = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;
		java.sql.PreparedStatement pst  = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
		
			String sql = "delete from cart where (name = ?)and(userid = ?) ;";
			pst = cnct.prepareStatement(sql);
			pst.setString(1, name);
			String userid = LoginInfo.getId();
			pst.setString(2, userid);
			pst.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				
				if(st!=null) st.close();
				
				if(cnct!=null) cnct.close();
				
				if(pst!=null) pst.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
