package cn.example.form;

import java.io.Serializable;

public class ProductForm  implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 9032159448193694391L;

	private String name;
	
	private String price;
	
	private String description;
	
	private String produced;
	
	public ProductForm(){
		
	}
	
	public ProductForm(String name,String price,String description){
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduced() {
		return produced;
	}

	public void setProduced(String produced) {
		this.produced = produced;
	}
	
	
	
}
