package com.anand.spring.shoppingbackend.daoimpl;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.Address;
import com.anand.spring.shoppingbackend.entities.ShoppingCart;
import com.anand.spring.shoppingbackend.entities.User;

/**
 * 
 * @author A Anand
 *
 */
public class UserDAOImplTest {

	private static AnnotationConfigApplicationContext context;
	private static DAO userDAOImpl;
	private static DAO addressDAOImpl;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anand.spring.shoppingbackend");
		context.refresh();

		try {
			userDAOImpl = (DAO) context.getBean("userDAOImpl");
			addressDAOImpl = (DAO) context.getBean("addressDAOImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void performTests() {
		
		User user = new User();
		user.setUserEmailAddress("asd@asd.com");
		user.setUserFirstName("First Name");
		user.setUserLastName("Last Name");
		user.setUserPassword("********");
		user.setUserPhoneNumber("1111111111");
		user.setUserRole("USER");
		
		if(user.getUserRole().equals("USER")) {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setCartNoOfItems(new Long(10));
			shoppingCart.setCartTotal(new Double(3000));
			shoppingCart.setUser(user);
			
			user.setShoppingCart(shoppingCart);
		}
		
		boolean result = userDAOImpl.save(user);
		assertEquals("Failed To Create User", result, true);
		
		user = (User) userDAOImpl.findByProperty("userFirstName", "First Name").get(0);
		System.out.println("USER: " + user.getUserId());
		Address address = new Address();
		address.setAddressBilling(true);
		address.setAddressCity("city");
		address.setAddressCountry("country");
		address.setAddressLineOne("lone one");
		address.setAddressLineTwo("line two");
		address.setAddressPostalCode("code");
		address.setAddressShipping(true);
		address.setAddressState("state");
		address.setAddressUserId(user.getUserId());
		
		result = addressDAOImpl.save(address);
		assertEquals("Failed To Create Address", result, true);
		
		Address address2 = new Address();
		address2.setAddressBilling(false);
		address2.setAddressCity("city");
		address2.setAddressCountry("country");
		address2.setAddressLineOne("lone one");
		address2.setAddressLineTwo("line two");
		address2.setAddressPostalCode("code");
		address2.setAddressShipping(true);
		address2.setAddressState("state");
		address2.setAddressUserId(user.getUserId());
		
		result = addressDAOImpl.save(address2);
		assertEquals("Failed To Create Address", result, true);
		
	}
}
