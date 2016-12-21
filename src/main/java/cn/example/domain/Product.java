package cn.example.domain;

import java.io.Serializable;
import java.util.Date;


public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3001776524738690185L;
	
	private long id;
	
	private String name;
	
	private float price;
	
	private String description;
	
	private Date produced;
	
	public Product(){
		
	}
	
	public Product(long id,String name,float price,String description){
		this.id=id;
		this.name=name;
		this.price=price;
		this.description=description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getProduced() {
		return produced;
	}

	public void setProduced(Date produced) {
		this.produced = produced;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
