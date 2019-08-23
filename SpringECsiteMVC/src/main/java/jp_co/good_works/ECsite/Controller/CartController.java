package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.good_works.ECsite.Form.BackForm;
import jp_co.good_works.ECsite.Form.CancelForm;
import jp_co.good_works.ECsite.Form.CartForm2;
import jp_co.good_works.ECsite.Form.CartInfo;
import jp_co.good_works.ECsite.Form.ChargeForm;
import jp_co.good_works.ECsite.Form.FinForm;
import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.JDBC.CancelDao;
import jp_co.good_works.ECsite.JDBC.CartDao;
import jp_co.good_works.ECsite.JDBC.CartInfoDao;
import jp_co.good_works.ECsite.JDBC.FinishDao;

@Controller
@Scope("session")public class CartController {
	ArrayList<CartInfo> List = new ArrayList<CartInfo>();
	double Tax =1.08;
	
	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("a");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		LoginInfo Info = new LoginInfo();
		System.out.println(Info.getUserId());
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		ChargeForm cf = new ChargeForm();
		model.addAttribute("ChargeForm", cf);
		
		if(CartForm2.getNum()==null) {
			CartDao cd = new CartDao();
			int $price = (int)(cd.price() * Tax);
			CartInfo ci = new CartInfo();
			CartInfoDao cid = new CartInfoDao();
			List = cid.CartInfoDaos();
			model.addAttribute("sumPrice", $price);
			model.addAttribute("CartInfo", ci);
			model.addAttribute("CartList", List);
			BackForm bf = new BackForm();
			model.addAttribute("BackForm", bf);
			CancelForm ccl = new CancelForm();
			model.addAttribute("CancelForm", ccl);
			return "/Cart";
		}else {
		int num = Integer.parseInt(CartForm2.getNum());
		System.out.println(num);
		String name = CartForm2.getPro_name();
		int price = Integer.parseInt(CartForm2.getPro_price());
		
		CartDao cd = new CartDao(name,price,num);
	
		int $price = (int)(cd.price() * Tax);
		System.out.println($price);
		CartInfo ci = new CartInfo();
		CartInfoDao cid = new CartInfoDao();
		List = cid.CartInfoDaos();
		model.addAttribute("sumPrice", $price);
		
		model.addAttribute("CartInfo", ci);
		model.addAttribute("CartList", List);
		BackForm bf = new BackForm();
		model.addAttribute("BackForm", bf);
		FinForm ff = new FinForm();
		model.addAttribute("FinForm", ff);
		CancelForm ccl = new CancelForm();
		model.addAttribute("CancelForm", ccl);
		return "/Cart";
		}
	}
	
	@RequestMapping(value = "/Cart", params="back" ,method = RequestMethod.POST)
	public String home2(Locale locale, Model model,@ModelAttribute BackForm bf) {
		
		
		
		return "redirect:/Search";
	}
	
	@RequestMapping(value = "/Cart", params="buy" ,method = RequestMethod.POST)
	public String home4(Locale locale, Model model,@ModelAttribute FinForm ff) {
		LoginInfo Info = new LoginInfo();
		int $p = Integer.parseInt(ff.getMoney());
		int $r = Integer.parseInt(Info.getMoney());
		if($p>$r) {
			model.addAttribute("message", "お金が足りません。チャージしてください");
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("userId",Info.getUserId());
			model.addAttribute("money",Info.getMoney());
			CartDao cd = new CartDao();
			int $price = (int)(cd.price() * Tax);
			CartInfo ci = new CartInfo();
			CartInfoDao cid = new CartInfoDao();
			List = cid.CartInfoDaos();
			model.addAttribute("sumPrice", $price);
			model.addAttribute("CartInfo", ci);
			model.addAttribute("CartList", List);
			BackForm bf = new BackForm();
			model.addAttribute("BackForm", bf);
			ChargeForm cf = new ChargeForm();
			model.addAttribute("ChargeForm", cf);
			CancelForm ccl = new CancelForm();
			model.addAttribute("CancelForm", ccl);
			
			return "/Cart";
		}else {
		int re = $r - $p ;
		new FinishDao(re);
		
		return "redirect:/Finish";
		}
	}
	
	@RequestMapping(value = "/Cart",params="charge", method = RequestMethod.POST) 
	public String initializeLogin2(Model model,Locale locale,
			@ModelAttribute ChargeForm cf) { 
		
		
		return "redirect:/Charge";
		
	}
	
	@RequestMapping(value = "/Cart",params="cancel", method = RequestMethod.POST) 
	public String initializeLogin6(Model model,Locale locale,
			@ModelAttribute CancelForm ccl) { 
		
		model.addAttribute("message", "キャンセルしました。");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		LoginInfo Info = new LoginInfo();
		model.addAttribute("userId",Info.getUserId());
		model.addAttribute("money",Info.getMoney());
		
		String name = ccl.getName();
		new CancelDao(name);
		
		CartDao cd = new CartDao();
		int $price = (int)(cd.price() * Tax);
		CartInfo ci = new CartInfo();
		CartInfoDao cid = new CartInfoDao();
		List = cid.CartInfoDaos();
		model.addAttribute("sumPrice", $price);
		model.addAttribute("CartInfo", ci);
		model.addAttribute("CartList", List);
		BackForm bf = new BackForm();
		model.addAttribute("BackForm", bf);
		ChargeForm cf = new ChargeForm();
		model.addAttribute("ChargeForm", cf);
		model.addAttribute("CancelForm", ccl);
		
		return "/Cart";
		
	}
}
