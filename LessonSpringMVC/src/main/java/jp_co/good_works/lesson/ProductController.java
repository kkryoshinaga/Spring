package jp_co.good_works.lesson;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */


@Scope("session")
@Controller 
public class ProductController {
	// productList‚ğ’è‹`
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping
	
	// /product‚ª“ü—Í‚³‚ê‚½‚Æ‚«‚ÉÀs
	(value = "/product", method = RequestMethod.GET)
	public String product(Model model) { 
		//gendersƒŠƒXƒg‚É’l‚ğŠi”[
		List<String> genders = new ArrayList<String>(); 
		genders.add("’j"); 
		genders.add("—"); 
		//genderƒŠƒXƒg‚ğgenders‚ÉŠi”[
		model.addAttribute("genders", genders);
		//birthplacesƒŠƒXƒg‚Ö’l‚ğŠi”[
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("–kŠC“¹"); birthplaces.add("“Œ–k"); 
		birthplaces.add("ŠÖ“Œ"); birthplaces.add("bM‰z"); 
		birthplaces.add("“ŒŠC"); birthplaces.add("ŠÖ¼");
		birthplaces.add("l‘"); birthplaces.add("’†‘"); 
		birthplaces.add("‹ãB"); birthplaces.add("‰«“ê"); 
		// birthplaces‚ÖƒZƒbƒg
		model.addAttribute("birthplaces", birthplaces); 
		//langs‚ÖŠi”[
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		//langs‚ğƒZƒbƒg
		model.addAttribute("langs", langs);
		//ProductForm‚ğƒCƒ“ƒXƒ^ƒ“ƒX‰»
		ProductForm form = new ProductForm(); 
		//message‚É’l‚ğŠi”[
		model.addAttribute("message", "¤•iî•ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
		//form‚ğƒZƒbƒg
		model.addAttribute("productForm", form); 
		//product.jsp‚Ö”ò‚Î‚·
		return "product"; 
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	
	public String product(Model model,@Validated @ModelAttribute ProductForm form,BindingResult result) 
	{  	
		
		if(result.hasErrors()) {
			model.addAttribute("message", "ƒGƒ‰[‚ª‚ ‚è‚Ü‚·");
		}else {
			model.addAttribute("message", "¤•iî•ñ‚ª“ü—Í‚³‚ê‚Ü‚µ‚½"); 
			//productList‚Öform‚ğŠi”[
			productList.add(form);
		}
		List<String> genders = new ArrayList<String>();
		genders.add("’j"); 
		genders.add("—");
		model.addAttribute("genders", genders);
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("–kŠC“¹"); birthplaces.add("“Œ–k"); 
		birthplaces.add("ŠÖ“Œ"); birthplaces.add("bM‰z"); 
		birthplaces.add("“ŒŠC"); birthplaces.add("ŠÖ¼");
		birthplaces.add("l‘"); birthplaces.add("’†‘"); 
		birthplaces.add("‹ãB"); birthplaces.add("‰«“ê"); 
		model.addAttribute("birthplaces", birthplaces); 
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		model.addAttribute("langs", langs);
		model.addAttribute("productForm", form); 
		model.addAttribute("productList", productList);
		return "product"; 
	}

}
