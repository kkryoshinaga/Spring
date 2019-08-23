package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.ECsite.Form.LoginForm;
import jp_co.good_works.ECsite.Form.RegsterForm;
import jp_co.good_works.ECsite.JDBC.RegsterDao;

@Controller
@Scope("session")public class RegsterController {
		
	@RequestMapping(value = "/Regster", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("message", "ìoò^èÓïÒÇì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢ÅB");
		LoginForm lf = new LoginForm();
		model.addAttribute("loginForm", lf);
		RegsterForm Rf = new RegsterForm();
		model.addAttribute("RegsterForm", Rf);
		
		return "/Regster";
	}
	
	@RequestMapping(value = "/Regster",params="send", method = RequestMethod.POST)
	public String home2(Locale locale, Model model,
			@Validated @ModelAttribute LoginForm form,  BindingResult result ) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("message", "ìoò^èÓïÒÇì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢ÅB");
		LoginForm lf = new LoginForm();
		model.addAttribute("loginForm", lf);
		RegsterForm Rf = new RegsterForm();
		model.addAttribute("RegsterForm", Rf);
		RegsterDao rd = new RegsterDao();
		if (result.hasErrors()) { 
			model.addAttribute("message", "ÉGÉâÅ[Ç™Ç†ÇËÇ‹Ç∑");
		}else if(rd.RegsterDaos(form.getUserId())){
			model.addAttribute("message", "ì¸óÕÇ≥ÇÍÇΩIDÇÕÇ∑Ç≈Ç…égópÇ≥ÇÍÇƒÇ¢Ç‹Ç∑ÅB");
		}else {
			String name = form.getUserId();
			String pass = form.getPassword();
			new RegsterDao(name,pass);
			model.addAttribute("message", "âÔàıìoò^Ç™äÆóπÇµÇ‹ÇµÇΩ");
			}
		return "/Regster";
	}
	
	@RequestMapping(value = "/Regster", params="regster" ,method = RequestMethod.POST)
	public String home3(Locale locale, Model model,@ModelAttribute RegsterForm Rf) {
		
		
		
		return "redirect:/Login";
	}
}
