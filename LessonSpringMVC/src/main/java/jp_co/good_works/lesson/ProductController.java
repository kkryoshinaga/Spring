package jp_co.good_works.lesson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller 
public class ProductController {
	@RequestMapping
	(value = "/product", method = RequestMethod.GET)
	public String product(Model model) { 
		ProductForm form = new ProductForm(); 
		model.addAttribute("message", "¤•iî•ñ‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
		model.addAttribute("productForm", form); 
		return "product"; 
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	public String product(Model model, 
			@ModelAttribute ProductForm form) 
	{ 
		model.addAttribute("message", "¤•iî•ñ‚ª“ü—Í‚³‚ê‚Ü‚µ‚½"); 
		model.addAttribute("productForm", form); return "product_result"; 
	}

}
