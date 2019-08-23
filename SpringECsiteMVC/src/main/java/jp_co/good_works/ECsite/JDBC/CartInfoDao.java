package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jp_co.good_works.ECsite.Form.CartInfo;
import jp_co.good_works.ECsite.Form.LoginInfo;

public class CartInfoDao {
	ArrayList<CartInfo> List = new ArrayList<CartInfo>();
	
	public ArrayList<CartInfo> CartInfoDaos(){
		
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String url = "jdbc:mysql://localhost/login";
			String id = "root";
			String pass = "password";

			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();
			String userid = LoginInfo.getId();
			String sql = "select * from cart where userid='"+userid+"';";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String price = rs.getString("price");
				String num = rs.getString("nums");
				int $price = 0;
				$price += (Integer.parseInt(price) * Integer.parseInt(num));
				
				CartInfo ci = new CartInfo();
				ci.setPro_name(name);
				ci.setPro_price(Integer.parseInt(price));
				ci.setPrice($price);
				ci.setNum(Integer.parseInt(num));
				List.add(ci);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}finally {
			
		}
		
		return List ;
	}
}
