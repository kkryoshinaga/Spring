package jp_co.good_works.ECsite.Logic;

import javax.security.auth.login.LoginException;

import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.UserDao;

public class LoginLogic {
	private LoginInfo loginInfo = null;// LoginForm �Ƃ͕ʂɍ쐬 
	boolean flag = false ; //flag�Ǘ�
	String money = null ; //�c����ݒ�
	/* ���O�C�������s���� */ 
	public LoginInfo login(String userId, String password) 
			throws LoginException {
	
		//UserDao���C���X�^���X�����A�c�����擾
		UserDao ud = new UserDao();
		money = ud.UserDaos(userId, password);
		
		if(money!=null) {
			
			flag = true ;
			
			
		}else {
		throw new LoginException("���[�UID�܂��̓p�X���[�h���Ⴂ�܂��B");
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
