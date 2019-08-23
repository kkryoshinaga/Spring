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

import jp_co.good_works.ECsite.Form.BackForm;
import jp_co.good_works.ECsite.Form.CartForm;
import jp_co.good_works.ECsite.Form.ChargeForm;
import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.ChargeDao;

@Controller
@Scope("session")public class ChargeController {
	boolean flag = false;
	@RequestMapping(value = "/Charge", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		LoginInfo Info = new LoginInfo();
		System.out.println(Info.getUserId());
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		model.addAttribute("message", "チャージ金額を入力してください");
		ChargeForm cf = new ChargeForm();
		model.addAttribute("ChargeForm", cf);
		CartForm cfm = new CartForm();
		model.addAttribute("CartForm", cfm);
		
		return "/Charge";
	}
	
	@RequestMapping(value = "/Charge",params="charge", method = RequestMethod.POST)
	public String home2(Locale locale, Model model,
			@Validated @ModelAttribute ChargeForm cf,  BindingResult result ) {
		
		System.out.println("sssssssssssssssss");
		if (result.hasErrors()) { 
			model.addAttribute("message", "エラーがあります");
		} else {
			int money = cf.getChargeMoney();
			System.out.println(money);
			ChargeDao cd = new ChargeDao();
			cd.ChargeDaos(money);
			model.addAttribute("message", "チャージが完了しました");
			}
		
		model.addAttribute("ChargeForm", cf);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		LoginInfo Info = new LoginInfo();
		System.out.println(Info.getUserId());
		model.addAttribute("userId",Info.getUserId());
		//
		model.addAttribute("money",Info.getMoney());
		BackForm bf = new BackForm();
		model.addAttribute("BackForm", bf);
		CartForm cfm = new CartForm();
		model.addAttribute("CartForm", cfm);
		
		return "/Charge";
	}
	
	@RequestMapping(value = "/Charge", params="back" ,method = RequestMethod.POST)
	public String home3(Locale locale, Model model,@ModelAttribute BackForm bf) {
		
		return "redirect:/Search";
	}
	
	@RequestMapping(value = "/Charge",params="next", method = RequestMethod.POST) 
	public String initializeLogin3(Model model,Locale locale,
			@ModelAttribute ChargeForm cf) { 
		
		
		return "redirect:/Cart";
		
	} 
}
