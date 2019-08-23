package jp_co.good_works.ECsite.Form;
import javax.validation.constraints.*;

public class ChargeForm {
	
	private String charge;
	
	@NotNull @Min(value = 100) @Max(value = 1000000) 
	private Integer chargeMoney;
	
	
	
	
	public Integer getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(Integer chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
}
