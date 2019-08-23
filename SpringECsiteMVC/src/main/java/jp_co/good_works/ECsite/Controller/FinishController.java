package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.ECsite.Form.BackForm;
import jp_co.good_works.ECsite.Form.LogOutForm;
import jp_co.good_works.ECsite.Form.LoginInfo;

@Controller 
@Scope("session")public class FinishController {
	
	@RequestMapping(value = "/Finish", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//åªç›éûçèÇéÊìæÇµÅAmodelÇ…äiî[
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		LoginInfo Info = new LoginInfo();
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		BackForm bf = new BackForm();
		model.addAttribute("BackForm", bf);
		LogOutForm lof = new LogOutForm();
		model.addAttribute("LogOutForm", lof);
		return "/Finish";
	}
	
	@RequestMapping(value = "/Finish", params="back" ,method = RequestMethod.POST)
	public String home2(Locale locale, Model model,@ModelAttribute BackForm bf) {
		
		
		
		return "redirect:/Search";
	}
	
	@RequestMapping(value = "/Finish", params="LogOut" ,method = RequestMethod.POST)
	public String home3(Locale locale, Model model,@ModelAttribute LogOutForm lof) {
		
		
		
		return "redirect:/Login";
	}
}
