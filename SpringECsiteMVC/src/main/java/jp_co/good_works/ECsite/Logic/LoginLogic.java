package jp_co.good_works.ECsite.Logic;

import javax.security.auth.login.LoginException;

import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.UserDao;

public class LoginLogic {
	private LoginInfo loginInfo = null;// LoginForm とは別に作成 
	boolean flag = false ; //flag管理
	String money = null ; //残金を設定
	/* ログインを実行する */ 
	public LoginInfo login(String userId, String password) 
			throws LoginException {
	
		//UserDaoをインスタンス化し、残金を取得
		UserDao ud = new UserDao();
		money = ud.UserDaos(userId, password);
		
		if(money!=null) {
			
			flag = true ;
			
			
		}else {
		throw new LoginException("ユーザIDまたはパスワードが違います。");
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
