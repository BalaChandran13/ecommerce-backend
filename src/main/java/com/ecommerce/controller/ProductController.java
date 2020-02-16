package com.ecommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getProductDetails(@RequestParam("filter_type") String filterType, @RequestParam("filter_value") String filterValue) {
		List<Product> productDetails = productService.getProductDetails(filterType,filterValue);
		return productDetails;
	}
	
	@PostMapping
	public Integer insertProductDetail(@RequestBody Product product) {
		Integer idValue = productService.insertProductDetail(product);
		return idValue;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductDetail(@PathVariable Integer id) {
		try {
		productService.deleteProductDetail(id);
		} catch (Exception e) {
			log.error("No such id");
		}
	}
	
}
