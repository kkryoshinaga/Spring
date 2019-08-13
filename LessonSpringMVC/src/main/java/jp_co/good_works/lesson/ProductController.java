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
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping

	(value = "/product", method = RequestMethod.GET)
	public String product(Model model) { 
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
		ProductForm form = new ProductForm(); 
		model.addAttribute("message", "¤•iî•ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
		model.addAttribute("productForm", form); 
		return "product"; 
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	public String product(Model model,@Validated @ModelAttribute ProductForm form,BindingResult result) 
	{  	
		if(result.hasErrors()) {
			model.addAttribute("message", "ƒGƒ‰[‚ª‚ ‚è‚Ü‚·");
		}else {
			model.addAttribute("message", "¤•iî•ñ‚ª“ü—Í‚³‚ê‚Ü‚µ‚½"); 
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
