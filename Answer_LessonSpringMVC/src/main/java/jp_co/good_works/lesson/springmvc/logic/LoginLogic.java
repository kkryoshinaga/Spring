package jp_co.good_works.lesson.springmvc.logic;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import jp_co.good_works.lesson.springmvc.dao.UserDao;
import jp_co.good_works.lesson.springmvc.form.LoginForm;

public class LoginLogic {
	UserDao ud = new UserDao();
	private LoginInfo loginInfo = null;
	LoginForm loginForm = new LoginForm();
	
	/*���O�C�����s*/
	public void login(String userID, String password)throws LoginException, SQLException {
		loginInfo = ud.select(userID, password);
		if(loginInfo!=null) {
//			loginInfo = new LoginInfo();
//			loginInfo.setUserID(userID);
//			loginInfo.setPassword(password);
		}else {
			throw new LoginException("���[�UID�܂��̓p�X���[�h���Ⴂ�܂�");
				
		}
		
	}
	
	public boolean isLive() {
		if(loginInfo!=null) {
			return true;
		}else{
			return false;
		}
	}

	

}
