package jp_co.good_works.lesson;

import javax.security.auth.login.LoginException;

public class LoginLogic {
	private LoginInfo loginInfo = null;// LoginForm �Ƃ͕ʂɍ쐬 
	boolean flag = false ;
	boolean flag2 = false ;
	/* ���O�C�������s���� */ 
	public LoginInfo login(String userId, String password) 
			throws LoginException {
		
		UserDao ud = new UserDao();
		//flag2 = ud.UserDaos(userId, password);
		
		if(flag2==true) {
			loginInfo = new LoginInfo();
			
			loginInfo.setUserId(userId);
			loginInfo.setPassword(password);
			
			flag = true ;
			
			
		}else {
		throw new LoginException("���[�UID�܂͂��p�X���[�h���Ⴂ�܂��B");
		}
		return loginInfo ;
		
	} 
	/* ���O�C���ς��ǂ������m�F���� */ 
	public boolean isLive() { 
		// loginInfo ���C���X�^���X������Ă���� true ��ԋp���� }
		if(!(loginInfo==null)) {
			flag = true ;
		}
		
		return 	flag ;
		
	}

}
