package jp_co.good_works.lesson;
import java.util.List;

import javax.validation.constraints.*; 
import org.hibernate.validator.constraints.*;

public class ProductForm {
	@NotEmpty
	private String name;
	
	@NotNull @Min(value = 0) @Max(value = 100) 
	private Integer price;

	private String gender;
	
	private String birthplace;
	
	private List<String> favoriteLangs; 
	
	private String mail;
	
	private String others;
	
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<String> getFavoriteLangs() {
		return favoriteLangs;
	}

	public void setFavoriteLangs(List<String> favoriteLangs) {
		this.favoriteLangs = favoriteLangs;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getprice() {
		return price;
	}
}
