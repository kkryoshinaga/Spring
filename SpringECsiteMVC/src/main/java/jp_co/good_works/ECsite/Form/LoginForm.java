package jp_co.good_works.ECsite.Form;


import org.hibernate.validator.constraints.*;

public class LoginForm {
	
	@NotEmpty
	private String userId;
	
	@NotEmpty
	private String password;
	
	private String send;

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
