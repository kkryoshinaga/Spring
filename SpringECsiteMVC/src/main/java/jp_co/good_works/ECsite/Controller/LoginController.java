package jp_co.good_works.ECsite.Controller;

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
import jp_co.good_works.ECsite.Logic.LoginLogic;

@Controller 
@Scope("session") public class LoginController {

	private LoginLogic loginLogic = new LoginLogic();

	public boolean isLive(){ 
		return loginLogic.isLive(); 
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("message","���͂��Ă�������");
		model.addAttribute("loginForm", form);
		return "Login";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST) 
	public String initializeLogin(Model model,
			@Validated @ModelAttribute LoginForm form, BindingResult result, 
			RedirectAttributes redirectAttr) { 
		if (!result.hasErrors()) { 
			try { 
				loginLogic.login(form.getUserId(), form.getPassword()); 
				return "Hello"; 

			} catch (LoginException ex) {
				model.addAttribute("message", ex.getLocalizedMessage()); 
			} 
		} else { 
			model.addAttribute("message", "���[�UID�A�p�X���[�h����͂��Ă��������B"); 
		} 
		return "Login";

	}

}
