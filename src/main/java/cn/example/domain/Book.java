package cn.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5588705755923667003L;
	
	private long id;
	
	@NotEmpty
	private String isbn;
	
	@NotEmpty
	@Size(min=3,max=20)
	private String title;
	
	@NotEmpty
	private String author;
	
	private Category category;
	
	@Past
	@NotNull
	private Date producedDate;
	
	public Book(){
		
	}
	
	public Book(long id,String isbn,String title,String author,Category category,
			Date producedDate){
		this.id=id;
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.category=category;
		this.producedDate=producedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getProducedDate() {
		return producedDate;
	}

	public void setProducedDate(Date producedDate) {
		this.producedDate = producedDate;
	}
	
}
