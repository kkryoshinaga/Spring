package jp_co.good_works.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	String url = "jdbc:mysql://localhost/login";
	String id = "root";
	String pass = "password";

	Connection cnct = null;
	Statement st  = null;
	ResultSet rs = null;
	boolean flag =false;
	
	boolean UserDaos(String name,String password){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pass);
			String sql = "SELECT * FROM USER WHERE USERID ='"+name+"';";
			
			st = cnct.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String userId = rs.getString("USERID");
				String ps = rs.getString("PASSWORD");
				if(name.equals(userId) && password.equals(ps)) {
					flag = true;
				}
				
			}

		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();

		}catch(SQLException ext) {
			ext.printStackTrace();
		}finally {
			try {
				if(cnct!=null) {
					cnct.close();
				}
				if(st!=null) {
					st.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception ex) {
				
			}

		}
		
		return flag;
	}

}
