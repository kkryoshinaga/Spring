package jp_co.good_works.ECsite.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.security.auth.login.LoginException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.ECsite.Form.LoginForm;
import jp_co.good_works.ECsite.Form.LoginInfo;
import jp_co.good_works.ECsite.Form.RegsterForm;
import jp_co.good_works.ECsite.JDBC.UserDao;
import jp_co.good_works.ECsite.Logic.LoginLogic;

@Controller 
@Scope("session") public class LoginController {

	private LoginLogic loginLogic = new LoginLogic();

	public boolean isLive(){ 
		return loginLogic.isLive(); 
	}

	// /Loginが押下されたとき以下が実行
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		//現在時刻を取得し、modelに格納
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		//LoginFormをformにインスタンス化
		LoginForm form = new LoginForm();
		model.addAttribute("loginForm", form);

		//messageに文字を格納し、modelにセット
		model.addAttribute("message","入力してください");

		RegsterForm Rf =  new RegsterForm();
		model.addAttribute("RegsterForm", Rf);

		return "Login";
	}

	//Login.jspで値が入力されたあとに実行
	@RequestMapping(value = "/Login", params="send" ,method = RequestMethod.POST) 
	public String initializeLogin(Model model,Locale locale,
			@Validated @ModelAttribute LoginForm form, BindingResult result, 
			RedirectAttributes redirectAttr) { 

		//現在時刻を取得し、modelにセット
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		//もしログイン処理に成功したら、以下を実行
		if (!result.hasErrors()) { 
			try { 

				//LofinLogicのLoginメソッドを実行
				loginLogic.login(form.getUserId(), form.getPassword()); 
				
				//UserDaoをインスタンス化
				UserDao dao = new UserDao();
				//UserDaoのUserDaosメソッドを実行し、残金を取得。
				String money = dao.UserDaos(form.getUserId(), form.getPassword());
				
				//LoginInfoをインスタンス化し、変数に入力
				LoginInfo Info = new LoginInfo();
				Info.setUserId(form.getUserId());
				Info.setPassword(form.getPassword());
				Info.setMoney(money);

				//Searchコントローラーへ飛ばす
				return "redirect:/Search";

			} catch (LoginException ex) {
				model.addAttribute("message", ex.getLocalizedMessage()); 
			} 
		} else { 
			model.addAttribute("message", "ユーザID、パスワードを入力してください。"); 
		} 

		RegsterForm Rf =  new RegsterForm();
		model.addAttribute("RegsterForm", Rf);
		
		return "Login";

	}

	@RequestMapping(value = "/Login", params="regster" ,method = RequestMethod.POST)
	public String home3(Locale locale, Model model,@ModelAttribute RegsterForm Rf) {



		return "redirect:/Regster";
	}

}
