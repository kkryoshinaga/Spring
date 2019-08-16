package jp_co.good_works.ECsite.Logic;

import javax.security.auth.login.LoginException;

import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.UserDao;

public class LoginLogic {
	private LoginInfo loginInfo = null;// LoginForm とは別に作成 
	boolean flag = false ;
	boolean flag2 = false ;
	/* ログインを実行する */ 
	public LoginInfo login(String userId, String password) 
			throws LoginException {
		
		UserDao ud = new UserDao();
		flag2 = ud.UserDaos(userId, password);
		
		if(flag2==true) {
			loginInfo = new LoginInfo();
			
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			
			flag = true ;
			
			
		}else {
		throw new LoginException("ユーザIDまはたパスワードが違います。");
		}
		return loginInfo ;
		
	} 
	/* ログイン済かどうかを確認する */ 
	public boolean isLive() { 
		// loginInfo がインスタンス化されていれば true を返却する }
		if(!(loginInfo==null)) {
			flag = true ;
		}
		
		return 	flag ;
		
	}

}
