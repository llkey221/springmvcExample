package cn.example.service;

import java.util.Map;

import cn.example.domain.Book;

public interface IBookService {
	
	Book save(Book book);
	
	Book get(long id) throws Throwable;
	
	void update(Book book);
	
	Map<Long, Book> getAllBooks();
}
