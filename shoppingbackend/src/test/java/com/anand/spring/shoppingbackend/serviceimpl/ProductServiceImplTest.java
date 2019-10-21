package com.anand.spring.shoppingbackend.serviceimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.services.ProductService;

public class ProductServiceImplTest {

	private static AnnotationConfigApplicationContext context;
	private static ProductService productServiceImpl;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anand.spring.shoppingbackend");
		context.refresh();
		
		try {
			productServiceImpl = (ProductService) context.getBean("productServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAllActiveProductsTest() {
		List<ProductDataForAllProducts> fetchedData = productServiceImpl.getAllActiveProducts();
		System.out.println(fetchedData);
	}
	
	@Test
	public void getAllActiveProductsByCategory() {
		List<ProductDataForAllProducts> fetchedData = productServiceImpl.getAllActiveProductsByCategory(new Long(1));
		System.out.println(fetchedData);
	}
	
	
	@Test
	public void getLatestActiveProducts() {
		List<ProductDataForAllProducts> fetchedData = productServiceImpl.getLatestActiveProducts(new Integer(5));
		System.out.println(fetchedData);
		assertEquals("Successfully Fetched Latest Active Products", 5, fetchedData.size());
	}
}
