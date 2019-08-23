package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.LoginInfo;

public class UserDao {
	
	//メソッド実行に必要な情報をあらかじめ用意
	String url = "jdbc:mysql://localhost/login";
	String id = "root";
	String pass = "password";
	
	//必要なクラスにnullを設定しておく
	Connection cnct = null;
	Statement st  = null;
	ResultSet rs = null;
	String money = null;

	public String UserDaos(String name,String password){

		try{
			//DBへの接続を開始する
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pass);
			
			//sql文をあらかじめ設定
			String sql = "SELECT * FROM USER WHERE USERID ='"+name+"';";
			
			//sql文を実行
			st = cnct.createStatement();
			rs = st.executeQuery(sql);
			
			//入力されたnameの情報を取得しそれぞれ変数に格納
			while(rs.next()) {
				String userId = rs.getString("USERID");
				String ps = rs.getString("PASSWORD");
				String money = rs.getString("money");
				String id = rs.getString("id");
				LoginInfo.setId(id);
				//
				if(name.equals(userId) && password.equals(ps)) {

					if(money==null) {
						money="0";
					}

					this.money = money;

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

		return money;
	}

}
