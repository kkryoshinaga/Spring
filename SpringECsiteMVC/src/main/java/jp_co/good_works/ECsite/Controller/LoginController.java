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

	// /Login���������ꂽ�Ƃ��ȉ������s
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		//���ݎ������擾���Amodel�Ɋi�[
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		//LoginForm��form�ɃC���X�^���X��
		LoginForm form = new LoginForm();
		model.addAttribute("loginForm", form);

		//message�ɕ������i�[���Amodel�ɃZ�b�g
		model.addAttribute("message","���͂��Ă�������");

		RegsterForm Rf =  new RegsterForm();
		model.addAttribute("RegsterForm", Rf);

		return "Login";
	}

	//Login.jsp�Œl�����͂��ꂽ���ƂɎ��s
	@RequestMapping(value = "/Login", params="send" ,method = RequestMethod.POST) 
	public String initializeLogin(Model model,Locale locale,
			@Validated @ModelAttribute LoginForm form, BindingResult result, 
			RedirectAttributes redirectAttr) { 

		//���ݎ������擾���Amodel�ɃZ�b�g
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		//�������O�C�������ɐ���������A�ȉ������s
		if (!result.hasErrors()) { 
			try { 

				//LofinLogic��Login���\�b�h�����s
				loginLogic.login(form.getUserId(), form.getPassword()); 
				
				//UserDao���C���X�^���X��
				UserDao dao = new UserDao();
				//UserDao��UserDaos���\�b�h�����s���A�c�����擾�B
				String money = dao.UserDaos(form.getUserId(), form.getPassword());
				
				//LoginInfo���C���X�^���X�����A�ϐ��ɓ���
				LoginInfo Info = new LoginInfo();
				Info.setUserId(form.getUserId());
				Info.setPassword(form.getPassword());
				Info.setMoney(money);

				//Search�R���g���[���[�֔�΂�
				return "redirect:/Search";

			} catch (LoginException ex) {
				model.addAttribute("message", ex.getLocalizedMessage()); 
			} 
		} else { 
			model.addAttribute("message", "���[�UID�A�p�X���[�h����͂��Ă��������B"); 
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
