package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp_co.good_works.ECsite.Form.BackForm;
import jp_co.good_works.ECsite.Form.CartForm;
import jp_co.good_works.ECsite.Form.CartForm2;
import jp_co.good_works.ECsite.Form.DetailForm;
import jp_co.good_works.ECsite.Form.DetailsForm;
import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.DetailDao;

@Controller 
@Scope("session")public class DetailController {
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		DetailForm form = new DetailForm();
		System.out.println(form.getPro_name());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		CartForm cartForm = new CartForm();
		model.addAttribute("CartForm", cartForm);
		BackForm bf = new BackForm();
		model.addAttribute("BackForm", bf);
		
		String name = form.getPro_name();
		DetailDao dd = new DetailDao();
		ArrayList<DetailsForm> DetailList = dd.DetailDaos(name);
		DetailsForm df = new DetailsForm();
		model.addAttribute("DetailList", DetailList);
		model.addAttribute("DetailsForm", df);
		
		LoginInfo Info = new LoginInfo();
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		
		List<String> numList = new ArrayList<String>(); 

		numList.add("1");numList.add("2");
		numList.add("3");numList.add("4");numList.add("5");
		numList.add("6");numList.add("7");numList.add("8");
		numList.add("9");numList.add("10");
		
		model.addAttribute("numList", numList);

		return "Detail";
	}

	@RequestMapping(value = "/Detail", params="next" ,method = RequestMethod.POST) 
	public String initializeLogin(Model model,Locale locale,
			  @ModelAttribute CartForm cf) { 
			
			String name = cf.getPro_name();
			String price = cf.getPro_price();
			String num = cf.getNums();
			
			
			
			CartForm2.setPro_name(name);
			CartForm2.setPro_price(price);
			CartForm2.setNum(num);
			
			return "redirect:/Cart";
		
			
	}
	
	@RequestMapping(value = "/Detail", params="back" ,method = RequestMethod.POST) 
	public String initializeLogin2(Model model,Locale locale,
			  @ModelAttribute BackForm form) { 
		
	
			return "redirect:/Search";
		
			
	}
}
