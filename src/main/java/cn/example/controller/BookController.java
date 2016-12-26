package cn.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.example.domain.Book;
import cn.example.domain.Category;
import cn.example.service.IBookService;
import cn.example.service.ICategoryService;
import cn.example.validator.BookValidator;

@Controller
public class BookController {

	private static Log logger=LogFactory.getLog(BookController.class);
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICategoryService categoryService;
	
/*	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(new BookValidator());
		binder.validate();
	}*/
	
	
	@RequestMapping(value="/book_input",method={RequestMethod.GET})
	public String inputBook(Model model,RedirectAttributes redirectAttributes){	
		
		Book book=new Book();
		model.addAttribute("book", book);
		
		List<Category> categories=categoryService.getAllCategories();
		
		model.addAttribute("categories", categories);
		
		
		return "bookForm";
	}
	
	@RequestMapping(value={"/book_save"},method={RequestMethod.POST})
	public String saveBook(HttpServletRequest request,@Valid @ModelAttribute Book book,BindingResult bindingResult,
			RedirectAttributes redirectAttributes,Model model){

		/*BookValidator  validator=new BookValidator();
		validator.validate(book, bindingResult);*/
		
		if(bindingResult.hasErrors()){
			
			FieldError fieldError= bindingResult.getFieldError();
			
			logger.error("Code:"+fieldError.getCode()+" £¬Field:"+fieldError.getField());
			
			System.out.println("Code:"+fieldError.getCode()+" £¬Field:"+fieldError.getField());
			
			redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
			
			List<Category> categories=categoryService.getAllCategories();
			
			model.addAttribute("categories", categories);
			model.addAttribute("book",book);
			
			/*return "redirect:book_input";*/
			return "bookForm";
		}
		
		logger.info("save book");
		
		List<MultipartFile> images=book.getImages();
		List<String> imgNames=new ArrayList<String>();
		
		if(images!=null && images.size()>0){
			for(MultipartFile multipartFile : images){
				String fileName=multipartFile.getOriginalFilename();
				imgNames.add(fileName);
				
				File file=new File(request.getServletContext().getRealPath("/images/")+
						fileName);
				
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					logger.error("ÉÏ´«Í¼Æ¬Ê§°Ü",e);
					e.printStackTrace();
				} catch (IOException e) {
					logger.error("ÉÏ´«Í¼Æ¬Ê§°Ü",e);
					e.printStackTrace();
				}
			}
		}
		
		Category category=categoryService.get(book.getCategory().getId());
		book.setCategory(category);
		
		bookService.save(book);
		
		return "redirect:book_list";
	}
	
	@RequestMapping(value="/book_edit/{id}",method={RequestMethod.GET})
	public String editBook(@PathVariable long id,Model model){
		
		try {
			Book book=bookService.get(id);
			List<Category> categories=categoryService.getAllCategories();
			model.addAttribute("book", book);
			model.addAttribute("categories", categories);
			
		} catch (Throwable e) {
			logger.error(e);
		}
		
		return "bookEditForm";
	}
	
	@RequestMapping(value="/book_update",method={RequestMethod.POST})
	public String updateBook(@ModelAttribute Book book,BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			
			redirectAttributes.addFlashAttribute("book",book);
			
			return"redirect:book_edit/"+book.getId();
		}
		
		try {
			Book bookOriginal=bookService.get(book.getId());
			
			bookOriginal.setTitle(book.getTitle());
			bookOriginal.setAuthor(book.getAuthor());
			bookOriginal.setIsbn(book.getIsbn());
			
			bookOriginal.setCategory(categoryService.get(book.getCategory().getId()));
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:book_list";
	}
	
	@RequestMapping(value={"/book_list"},method={RequestMethod.GET})
	public String bookList(Model model){
		
		Map<Long, Book> bookList=bookService.getAllBooks();
		
		List<Book> books=new ArrayList<Book>(bookList.values());
		model.addAttribute("bookList",books);
		
		return "bookList";
	}
	
	
}
