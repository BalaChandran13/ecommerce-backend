package com.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductService.class)
public class ProductServiceTest {

	@MockBean
	private ProductRepository productRepo;
	
	@Autowired
	private ProductService prodService;
	
	@Test
	public void getsAllDataIfFilterIsNull() {
		prodService.getProductDetails(null, "");
		Mockito.verify(productRepo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getsDataByBrandIfFilterTypeIsBrand() {
		prodService.getProductDetails("brand", "test");
		Mockito.verify(productRepo, Mockito.times(1)).findByBrand("test");
	}
	
	@Test
	public void getsDataByBrandIfFilterTypeIsSize() {
		prodService.getProductDetails("size", "test");
		Mockito.verify(productRepo, Mockito.times(1)).findBySize("test");
	}
	
	@Test
	public void getsDataByBrandIfFilterTypeIsPrice() {
		prodService.getProductDetails("price", Float.valueOf(1).toString());
		Mockito.verify(productRepo, Mockito.times(1)).findByPrice(Float.valueOf(1));
	}

	@Test
	public void insertsProduct() {
		Product product = mock(Product.class);
		Mockito.doReturn(product).when(productRepo).save(product);
		assertEquals(Integer.valueOf(0), prodService.insertProductDetail(product));
	}
	
	@Test
	public void deleteProduct() {
		prodService.deleteProductDetail(0);
		Mockito.verify(productRepo, Mockito.times(1)).deleteById(Integer.valueOf(0));
	}
}
