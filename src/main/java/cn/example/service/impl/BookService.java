package cn.example.service.impl;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import cn.example.domain.Book;
import cn.example.service.IBookService;

@Service
public class BookService implements IBookService {

	private static Map<Long,Book> books=new HashMap<Long,Book>();
	
	private AtomicLong generator=new AtomicLong();
	
	public Book save(Book book) {
		
		long id=generator.getAndIncrement();
		book.setId(id);
		
		books.put(id, book);
		
		return book;
	}

	public Book get(long id) throws Throwable {
		
		if (books.containsKey(id)) {
			Book book = books.get(id);
			return book;
		}else{
			throw new Exception(String.format("Not exists id=%s books",id));			
		}
		
	}

	public void update(Book book) {
		
		if(book==null ||book.getId()<=0){
			throw new InvalidParameterException("Book does't allow null");
		}
		
		if(books.containsKey(book.getId())){
			Book tmpBook=books.get(book.getId());
			
			tmpBook.setIsbn(book.getIsbn());
			tmpBook.setTitle(book.getTitle());
			tmpBook.setAuthor(book.getAuthor());
			tmpBook.setCategory(book.getCategory());
		}
	}

	public Map<Long, Book> getAllBooks() {
		return books;
	}

}
