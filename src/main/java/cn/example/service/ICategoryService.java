package cn.example.service;

import java.util.List;

import cn.example.domain.Category;

public interface ICategoryService {
	Category get(long id);
	
	List<Category> getAllCategories();
}
