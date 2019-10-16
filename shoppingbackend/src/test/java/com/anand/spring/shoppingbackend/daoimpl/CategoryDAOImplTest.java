package com.anand.spring.shoppingbackend.daoimpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.Category;

public class CategoryDAOImplTest {

	private static AnnotationConfigApplicationContext context;
	private static DAO categoryDAOImpl;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anand.spring.shoppingbackend");
		context.refresh();
		
		try {
			categoryDAOImpl = (DAO) context.getBean("categoryDAOImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void crudTest() {
		
		saveTest("Mobiles");
		saveTest("Television");
		saveTest("Watches");
		
		findByIdTest();
		updateTest();
		findAllTest(3);
		deleteTest();
		findAllTest(2);
	}
	
	public void saveTest(String name) {
		category = new Category();
		category.setCategoryName(name);
		category.setCategoryDescription("Description");
		category.setCategoryIsActive(true);
		
		assertEquals("Successfully Saved Category", true, categoryDAOImpl.save(category));
	}
	
	public void findByIdTest() {
		Category category = (Category) categoryDAOImpl.findById(new Long(2));
		
		assertEquals("Successfully Fetched Category", "Television", category.getCategoryName());
	}
	
	public void updateTest() {
		Category category = (Category) categoryDAOImpl.findById(new Long(1));
		category.setCategoryDescription("Updated Description");
		
		assertEquals("Successfully Updated Category", true, categoryDAOImpl.update(category));
	}
	
	public void deleteTest() {
		Category category = (Category) categoryDAOImpl.findById(new Long(2));
		categoryDAOImpl.delete(category);
		
		category = (Category) categoryDAOImpl.findById(new Long(2));
		
		assertEquals("Successfully Deleted Category", false, category.getCategoryIsActive());
	}
	
	public void findAllTest(int expectedSize) {
		List<?> fetchedData = categoryDAOImpl.findAll();
		
		assertEquals("Successfully Fetched All Categories", expectedSize, fetchedData.size());
	}
}
