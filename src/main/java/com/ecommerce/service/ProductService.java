package com.ecommerce.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductDetails(String filterType, String filterValue){
		if(Objects.isNull(filterType) || (filterValue.equals(""))) {
			return productRepository.findAll();
		}else if(filterType.equalsIgnoreCase("Brand")) {
			return productRepository.findByBrand(filterValue);
		}else if(filterType.equalsIgnoreCase("Size")) {
			return productRepository.findBySize(filterValue);
		}else if(filterType.equalsIgnoreCase("Price")) {
			return productRepository.findByPrice(Float.valueOf(filterValue));
		}else {
			return productRepository.findAll();
		}
	}
	
	public Integer insertProductDetail(Product product){
		Product productDetatil = productRepository.save(product);
		return productDetatil.getId();	
	}

	public void deleteProductDetail(Integer product) {
		productRepository.deleteById(product);
	}
}
