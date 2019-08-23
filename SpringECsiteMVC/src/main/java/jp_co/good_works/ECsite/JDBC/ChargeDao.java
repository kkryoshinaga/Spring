package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.LoginInfo;

public class ChargeDao {
	
	public void ChargeDaos(int money) {
		
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
			LoginInfo lg = new LoginInfo();
			String name = lg.getUserId();
			String sql = "SELECT * FROM USER WHERE USERID ='"+name+"';";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String get_money = rs.getString("money");
				if(get_money==null) {
					get_money="0";
				}
				money += Integer.parseInt(get_money);
				String sql2 = "update user set money = ? where userid = ? ;";
				pst = cnct.prepareStatement(sql2);
				pst.setString(1, String.valueOf(money));
				pst.setString(2,name);
				pst.executeUpdate();
				lg.setMoney(String.valueOf(money));
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
				
				if(pst!=null) pst.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
