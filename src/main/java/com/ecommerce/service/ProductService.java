package com.ecommerce.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.Filter;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@Component
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductDetails(Filter filter){
		if(Objects.isNull(filter.getFilterType()) || (filter.getFilterValue().equals(""))) {
			return productRepository.findAll();
		}else if(filter.getFilterType().equalsIgnoreCase("Brand")) {
			return productRepository.findByBrand(filter.getFilterValue());
		}else if(filter.getFilterType().equalsIgnoreCase("Size")) {
			return productRepository.findBySize(filter.getFilterValue());
		}else if(filter.getFilterType().equalsIgnoreCase("Price")) {
			return productRepository.findByPrice(Float.valueOf(filter.getFilterValue()));
		}else {
			return productRepository.findAll();
		}
	}
	
	public Product getProductById(Product product){
		Optional<Product> productDetatil = productRepository.findById(product.getId());
		return productDetatil.orElse(new Product());
	}
	
	public Integer insertProductDetail(Product product){
		Product productDetatil = productRepository.save(product);
		return productDetatil.getId();	
	}

	public void deleteProductDetail(Integer product) {
		productRepository.deleteById(product);
	}
}
