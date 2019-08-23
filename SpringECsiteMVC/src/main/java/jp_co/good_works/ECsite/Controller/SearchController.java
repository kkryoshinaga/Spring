package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.ECsite.Form.ChargeForm;
import jp_co.good_works.ECsite.Form.DetailForm;
import jp_co.good_works.ECsite.Form.LogOutForm;
import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.Form.ProductForm;
import jp_co.good_works.ECsite.Form.ProductSearch;
import jp_co.good_works.ECsite.JDBC.SearchDao;

@Controller
@Scope("session")public class SearchController {
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		ProductSearch ProductSearch = new ProductSearch();
		List<String> category = new ArrayList<String>(); 

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		category.add("カテゴリ"); category.add("食品"); category.add("家電");
		category.add("生活用品");category.add("コスメ");category.add("ゲーム");
		model.addAttribute("category",category);
		model.addAttribute("ProductSearch", ProductSearch);
		LoginInfo Info = new LoginInfo();
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		LogOutForm lf = new LogOutForm();
		model.addAttribute("LogOutForm", lf);
		
		return "Search";
	}

	@RequestMapping(value = "/Search",params="search", method = RequestMethod.POST) 
	public String initializeLogin(Model model,Locale locale,
			@ModelAttribute ProductSearch ps, BindingResult result, 
			RedirectAttributes redirectAttr,@ModelAttribute DetailForm df) { 
		
			
		String cate = ps.getCategory();
		String word = ps.getWord();
		
		SearchDao sd = new SearchDao();
		ProductForm ProductForm = new ProductForm();
		
		ArrayList<ProductForm> productList = sd.SearchDaos(cate, word);
		System.out.println(productList);
		//productList.add(productForm);
		model.addAttribute("productList", productList);
		model.addAttribute("ProductForm",ProductForm);
		System.out.println("model="+model);

		//	productList.clear();

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		List<String> category = new ArrayList<String>(); 
		category.add("カテゴリ"); category.add("食品"); category.add("家電");
		category.add("生活用品");category.add("コスメ");category.add("ゲーム");
		model.addAttribute("category",category);
		
		model.addAttribute("ProductSearch", ps);
		LoginInfo Info = new LoginInfo();
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		
		ChargeForm cf = new ChargeForm();
		model.addAttribute("ChargeForm", cf);
		LogOutForm lf = new LogOutForm();
		model.addAttribute("LogOutForm", lf);
		
		return "Search";
		
	}
	
	@RequestMapping(value = "/Search",params="pro_name", method = RequestMethod.POST) 
	public String initializeLogin1(Model model,Locale locale,
			@ModelAttribute ProductSearch ps, BindingResult result, 
			RedirectAttributes redirectAttr,@ModelAttribute DetailForm df) { 
		
		
		return "redirect:Detail";
		
	} 
	
	@RequestMapping(value = "/Search",params="charge", method = RequestMethod.POST) 
	public String initializeLogin2(Model model,Locale locale,
			@ModelAttribute ChargeForm cf) { 
		
		
		return "redirect:/Charge";
		
	} 
	
	@RequestMapping(value = "/Search",params="next", method = RequestMethod.POST) 
	public String initializeLogin3(Model model,Locale locale,
			@ModelAttribute ChargeForm cf) { 
		
		
		return "redirect:/Cart";
		
	} 
	
	@RequestMapping(value = "/Search", params="LogOut" ,method = RequestMethod.POST)
	public String home3(Locale locale, Model model,@ModelAttribute LogOutForm lof) {
		
		
		
		return "redirect:/Login";
	}
}
