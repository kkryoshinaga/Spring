package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.CartForm2;
import jp_co.good_works.ECsite.Form.LoginInfo;


public class CartDao {
	
	public CartDao() {
		
	}
	boolean flag = false;
	public  CartDao(String name,int price,int num){
		
		Connection cnct = null;
		java.sql.PreparedStatement pst  = null;
		java.sql.PreparedStatement pstt  = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			String url = "jdbc:mysql://localhost/login";
			String id = "root";
			String pass = "password";

			


			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			String userid = LoginInfo.getId();
			String sql1 = "select * from cart where (name ='"+name+"')and(userid = '"+userid+"');";
			st = cnct.createStatement();
			rs = st.executeQuery(sql1);

			while(rs.next()) {

				String pro_num = rs.getString("nums");

				num += Integer.parseInt(pro_num);
				String sql2 = "update cart set nums = ? where (name = ?)and(userid = '"+userid+"') ;";
				pst = cnct.prepareStatement(sql2);
				pst.setInt(1, num);
				pst.setString(2, name);
				pst.executeUpdate();
				flag =true;

			}


			if(!(flag==true)) {
				String sql3 = "insert into cart(name,price,nums,userid) values(?,?,?,?);"; 
				pstt = cnct.prepareStatement(sql3);
				pstt.setString(1, name);
				pstt.setInt(2, price);
				pstt.setInt(3, num);
				pstt.setString(4, userid);
				pstt.executeUpdate();
				flag = false;

			}
			//
			CartForm2.setNum(null);

		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			
			try {
				if(rs!=null) {
					rs.close();
				}
				if(st!=null) {
					st.close();
				}
				if(pst!=null) {
					pst.close();
				}
				if(pstt!=null) {
					pstt.close();
				}
				if(cnct!=null) {
					cnct.close();
				}
			}catch(Exception ex) {
				
			}

		}


	}
	
	public int price() {
		
		int $price = 0;
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://localhost/login";
			String id = "root";
			String pass = "password";

			
			
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			String userid = LoginInfo.getId();
			String sql = "select * from cart where userid = '"+userid+"';";
			st = cnct.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String price1 = rs.getString("price") ;
				String num1 = rs.getString("nums");
				$price += (Integer.parseInt(price1) * Integer.parseInt(num1));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(st!=null) {
					st.close();
				}
				if(cnct!=null) {
					cnct.close();
				}
			}catch(Exception ex) {
				
			}
			
		}
		return $price;
	}
}
