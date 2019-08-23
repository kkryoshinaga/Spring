package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jp_co.good_works.ECsite.Form.DetailsForm;

public class DetailDao {
	ArrayList<DetailsForm> List = new ArrayList<DetailsForm>(); 
	
	public ArrayList<DetailsForm> DetailDaos(String name) {

		String url = "jdbc:mysql://localhost/login";
		String id = "root";
		String pass = "password";

		Connection cnct = null;
		Statement st  = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url,id,pass);
			System.out.println(name);
			String sql = "Select * from product where pro_name ='"+name+"';";
			st = cnct.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				DetailsForm form = new DetailsForm();
				String pro_name = rs.getString("pro_name");
				String pro_price = rs.getString("pro_price");
				String pro_pic = rs.getString("pro_pic");
				String pro_req = rs.getString("pro_req");
				System.out.println(pro_name);
				System.out.println(pro_req);
				form.setPro_name(pro_name);
				form.setPro_price(pro_price);
				form.setPro_pic(pro_pic);
				form.setPro_req(pro_req);

				List.add(form);

			}
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(SQLException ex) {
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





		return List;
	}
}
