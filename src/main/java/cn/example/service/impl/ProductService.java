package cn.example.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import cn.example.domain.Product;
import cn.example.service.IProductService;


@Service
public class ProductService implements IProductService{

	private Map<Long, Product> productMap=new HashMap<Long,Product>();
	
	private AtomicLong generator=new AtomicLong();
	
	public Product saveProduct(Product product) throws Exception {
		
		product.setId(generator.incrementAndGet());
		
		productMap.put(product.getId(), product);
		
		for (Product product2 : productMap.values()) {
			System.out.println(String.format("Product:name=%s,price=%f,descrpiton=%s",
					product2.getName(),product2.getPrice(),product2.getDescription()));
		}
		
		for(Entry<Long, Product> productEntry :productMap.entrySet()){
			System.out.println(productEntry.getKey());
			System.out.println(String.format("Product:name=%s,price=%f,descrpiton=%s",
					productEntry.getValue().getName(),productEntry.getValue().getPrice(),productEntry.getValue().getDescription()));
		}
		
		
		return product;
	}

	public Product getProductById(Long id) {
		
		if(productMap.containsKey(id)){
			return productMap.get(id);
		}else{
			return null;
		}	
	}
}
