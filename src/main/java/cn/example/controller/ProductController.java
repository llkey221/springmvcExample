package cn.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.example.domain.Product;
import cn.example.form.ProductForm;
import cn.example.service.IProductService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private static Log logger=LogFactory.getLog(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value="/input")
	public String inputProduct(){
		return "productForm";
	}
	
	@RequestMapping(value="/save",method={RequestMethod.POST})
	public String saveProduct(ProductForm productForm,Model model,
			RedirectAttributes redirectAttributes){
		
		Product product=new Product();
		product.setName(productForm.getName());
		
		try {	
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			product.setDescription(productForm.getDescription());
			
			Product product2= productService.saveProduct(product);
			
			/*model.addAttribute("product", product2);*/
			
			product.setId(product2.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			
			return "redirect:input";
		}
		
		redirectAttributes.addFlashAttribute("message","Save a product");
		
		return "redirect:get/"+product.getId();
	}
	
	@RequestMapping(value="/get/{id}")
	public String getProduct(@PathVariable long id,Model model){
		Product product= productService.getProductById(id);
		
		model.addAttribute("product",product);
		
		return "productDetail";
	}
	
}
