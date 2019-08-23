package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegsterDao {
	
	public RegsterDao() {
		
	}
	
	public RegsterDao(String name,String pass) {
		
		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String passs = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;
		java.sql.PreparedStatement pst  = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,passs);
			st = cnct.createStatement();
		
			String sql = "insert into user(userid,password) values(?,?) ;";
			pst = cnct.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
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
	
	public boolean RegsterDaos(String name) {
		boolean flag = false;
		
		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String passs = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,passs);
			st = cnct.createStatement();
		
			String sql = "select * from user where userid = '"+name+"';";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				flag = true;
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				
				if(st!=null) st.close();
				
				if(cnct!=null) cnct.close();
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return flag;
	}
}
