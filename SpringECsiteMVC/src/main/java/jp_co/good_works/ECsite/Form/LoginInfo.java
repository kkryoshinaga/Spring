package jp_co.good_works.ECsite.Form;



public  class LoginInfo {
	
	static String userId;
	
	
	static String password;
	
	static String money;
	
	static String id ;

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LoginInfo.id = id;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		LoginInfo.money = money;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		LoginInfo.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		LoginInfo.password = password;
	}
	
	
}
