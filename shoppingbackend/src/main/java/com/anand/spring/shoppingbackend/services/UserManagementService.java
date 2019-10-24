package com.anand.spring.shoppingbackend.services;

import java.util.List;

import com.anand.spring.shoppingbackend.entities.Address;
import com.anand.spring.shoppingbackend.entities.ShoppingCart;
import com.anand.spring.shoppingbackend.entities.User;

/**
 * 
 * @author A Anand
 *
 */
public interface UserManagementService {

	public boolean createUser(User user);
	
	public User getUserByEmail(String emailAddress);
	
	public List<Address> getAllAddresses(Long userId);
	
	public List<Address> getAllShippingAddresses(Long userId);

	public List<Address> getAllBillingAddresses(Long userId);
	
	public boolean updateCart(ShoppingCart shoppingCart);
}
