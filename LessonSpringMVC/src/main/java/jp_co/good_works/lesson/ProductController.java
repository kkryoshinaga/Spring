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
	// productList���`
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping
	
	// /product�����͂��ꂽ�Ƃ��Ɏ��s
	(value = "/product", method = RequestMethod.GET)
	public String product(Model model) { 
		//genders���X�g�ɒl���i�[
		List<String> genders = new ArrayList<String>(); 
		genders.add("�j"); 
		genders.add("��"); 
		//gender���X�g��genders�Ɋi�[
		model.addAttribute("genders", genders);
		//birthplaces���X�g�֒l���i�[
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("�k�C��"); birthplaces.add("���k"); 
		birthplaces.add("�֓�"); birthplaces.add("�b�M�z"); 
		birthplaces.add("���C"); birthplaces.add("�֐�");
		birthplaces.add("�l��"); birthplaces.add("����"); 
		birthplaces.add("��B"); birthplaces.add("����"); 
		// birthplaces�փZ�b�g
		model.addAttribute("birthplaces", birthplaces); 
		//langs�֊i�[
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		//langs���Z�b�g
		model.addAttribute("langs", langs);
		//ProductForm���C���X�^���X��
		ProductForm form = new ProductForm(); 
		//message�ɒl���i�[
		model.addAttribute("message", "���i������͂��Ă�������");
		//form���Z�b�g
		model.addAttribute("productForm", form); 
		//product.jsp�֔�΂�
		return "product"; 
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	
	public String product(Model model,@Validated @ModelAttribute ProductForm form,BindingResult result) 
	{  	
		
		if(result.hasErrors()) {
			model.addAttribute("message", "�G���[������܂�");
		}else {
			model.addAttribute("message", "���i��񂪓��͂���܂���"); 
			//productList��form���i�[
			productList.add(form);
		}
		List<String> genders = new ArrayList<String>();
		genders.add("�j"); 
		genders.add("��");
		model.addAttribute("genders", genders);
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("�k�C��"); birthplaces.add("���k"); 
		birthplaces.add("�֓�"); birthplaces.add("�b�M�z"); 
		birthplaces.add("���C"); birthplaces.add("�֐�");
		birthplaces.add("�l��"); birthplaces.add("����"); 
		birthplaces.add("��B"); birthplaces.add("����"); 
		model.addAttribute("birthplaces", birthplaces); 
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		model.addAttribute("langs", langs);
		model.addAttribute("productForm", form); 
		model.addAttribute("productList", productList);
		return "product"; 
	}

}
