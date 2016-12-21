package cn.example.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.example.domain.Category;
import cn.example.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	private static List<Category> categories=new ArrayList<Category>();
	
	static{
		Category category=new Category(1, "Computer Science");
		categories.add(category);
		
		Category categoryMath=new Category(2,"Mathematics");		
		categories.add( categoryMath);
		
		Category categoryFiction  =new Category(3,"Science fiction");
		categories.add(categoryFiction);
		
	}
	
	
	public Category get(long id) {
		
		for(Category category : categories){
			
			if(category.getId()==id){
				return category;
			}
			
		}
		
		return null;
	}

	public List<Category> getAllCategories() {
		
		return categories;
		
	}

}
