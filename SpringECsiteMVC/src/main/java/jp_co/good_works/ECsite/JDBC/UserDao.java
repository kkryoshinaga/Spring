package jp_co.good_works.ECsite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp_co.good_works.ECsite.Form.LoginInfo;

public class UserDao {
	
	//���\�b�h���s�ɕK�v�ȏ������炩���ߗp��
	String url = "jdbc:mysql://localhost/login";
	String id = "root";
	String pass = "password";
	
	//�K�v�ȃN���X��null��ݒ肵�Ă���
	Connection cnct = null;
	Statement st  = null;
	ResultSet rs = null;
	String money = null;

	public String UserDaos(String name,String password){

		try{
			//DB�ւ̐ڑ����J�n����
			Class.forName("com.mysql.jdbc.Driver");
			cnct = DriverManager.getConnection(url, id, pass);
			
			//sql�������炩���ߐݒ�
			String sql = "SELECT * FROM USER WHERE USERID ='"+name+"';";
			
			//sql�������s
			st = cnct.createStatement();
			rs = st.executeQuery(sql);
			
			//���͂��ꂽname�̏����擾�����ꂼ��ϐ��Ɋi�[
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
