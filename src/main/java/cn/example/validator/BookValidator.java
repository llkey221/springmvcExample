package cn.example.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cn.example.domain.Book;

public class BookValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		
		return Book.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Book book=(Book)target;
		
		ValidationUtils.rejectIfEmpty(errors, "title", "book.title.required");
		ValidationUtils.rejectIfEmpty(errors, "author", "book.author.required");
		ValidationUtils.rejectIfEmpty(errors, "isbn", "book.isbn.required");
		
		Date producedDate=book.getProducedDate();
		
		if(producedDate!=null){
			if(producedDate.after(new Date())){
				System.out.println("salah lagi");
				errors.rejectValue("producedDate", "book.producedDate.valid");
			}
		}else{
			errors.rejectValue("producedDate", "book.producedDate.required");
		}
		
	}

}
