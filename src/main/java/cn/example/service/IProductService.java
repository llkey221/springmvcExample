package cn.example.service;

import cn.example.domain.Product;

public interface IProductService {
	public Product saveProduct(Product product) throws Exception;
	
	public Product getProductById(Long id);
}
