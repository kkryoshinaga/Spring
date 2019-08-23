package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.LoginInfo;

public class FinishDao {
	public FinishDao(int money) {
		
		
		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String pass = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;
		java.sql.PreparedStatement pst  = null;
		java.sql.PreparedStatement pstt  = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			String userid = LoginInfo.getId();
			String sql = "delete from cart where userid = '"+userid+"';";
			pst = cnct.prepareStatement(sql);
			pst.executeUpdate();
			
			String sql2 ="update user set money = ? where userid = ? ;";
			LoginInfo info = new LoginInfo();
			String name = info.getUserId();
			pstt = cnct.prepareStatement(sql2);
			pstt.setString(1, String.valueOf(money));
			pstt.setString(2, name);
			pstt.executeUpdate();
			
			info.setMoney(String.valueOf(money));
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
				
				if(pstt!=null) pstt.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
