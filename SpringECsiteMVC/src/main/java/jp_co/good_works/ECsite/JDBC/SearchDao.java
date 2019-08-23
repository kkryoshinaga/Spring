package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jp_co.good_works.ECsite.Form.ProductForm;

public class SearchDao {
	ArrayList<ProductForm> List = new ArrayList<ProductForm>(); 
	public ArrayList<ProductForm> SearchDaos(String cate , String word) {

		
		
		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String pass = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			st = cnct.createStatement();

			if((cate.equals("カテゴリ")) && (word==null || word.equals(""))) {
				
				String sql = "Select * from product ;";
				rs = st.executeQuery(sql);
				while(rs.next()) {
					ProductForm form = new ProductForm();
					
					String name = rs.getString("pro_name");
					String price = rs.getString("pro_price");
					form.setPro_name(name);
					form.setPro_price(price);
	
	
	//form.setPro_name(rs.getString("pro_name"));
					//form.setPro_price(rs.getString("pro_price"));
//					System.out.println(rs.getString("pro_name") +","+rs.getString("pro_price")+",");
					List.add(form);
				}
				System.out.println("Listの中身は"+List);
				
			}else if(!(cate.equals("カテゴリ")) && (word==null || word.equals(""))) {
				String sql = "select * from product where cate = '"+cate+"';";
				rs = st.executeQuery(sql);
				while(rs.next()) {
					ProductForm form = new ProductForm();
					
					String name = rs.getString("pro_name");
					String price = rs.getString("pro_price");
					form.setPro_name(name);
					form.setPro_price(price);
					//form.setPro_name(rs.getString("pro_name"));
					//form.setPro_price(rs.getString("pro_price"));
					
					List.add(form);
				}
				
			}else if(cate.equals("カテゴリ") && (word!=null)) {
				
				String sql = "Select * from product where pro_name Like '%" +word+ "%' ;";
				
				rs = st.executeQuery(sql);
				while(rs.next()) {
					ProductForm form = new ProductForm();
					
					String name = rs.getString("pro_name");
					String price = rs.getString("pro_price");
					form.setPro_name(name);
					form.setPro_price(price);
					//form.setPro_name(rs.getString("pro_name"));
					//form.setPro_price(rs.getString("pro_price"));

					List.add(form);
				}
			}else {
				String sql = "select * from product where (cate = '"+cate+"')&(pro_name like '%" +word+ "%');";
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					ProductForm form = new ProductForm();
					
					String name = rs.getString("pro_name");
					String price = rs.getString("pro_price");
					form.setPro_name(name);
					form.setPro_price(price);
					//form.setPro_name(rs.getString("pro_name"));
					//form.setPro_price(rs.getString("pro_price"));
					List.add(form);
				}
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
				ex.printStackTrace();
			}
		}

		return List;
	}
}
