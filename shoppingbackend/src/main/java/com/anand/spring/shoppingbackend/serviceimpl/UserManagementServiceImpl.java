package com.anand.spring.shoppingbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anand.spring.shoppingbackend.dao.AddressDAO;
import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.Address;
import com.anand.spring.shoppingbackend.entities.ShoppingCart;
import com.anand.spring.shoppingbackend.entities.User;
import com.anand.spring.shoppingbackend.services.UserManagementService;

/**
 * 
 * @author A Anand
 *
 */
@Service
@SuppressWarnings("unchecked")
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	@Qualifier(value = "userDAOImpl")
	private DAO userDAOImpl;

	@Autowired
	@Qualifier(value = "addressDAOImpl")
	private DAO addressDAOImpl;
	

	@Autowired
	@Qualifier(value = "shoppingCartDAOImpl")
	private DAO shoppingCartDAOImpl;

	@Override
	public boolean createUser(User user) {
		return userDAOImpl.save(user);
	}

	@Override
	public User getUserByEmail(String emailAddress) {
		List<?> result = userDAOImpl.findByProperty("userEmailAddress", emailAddress);
		return (User) result.get(0);
	}

	@Override
	public List<Address> getAllAddresses(Long userId) {
		return (List<Address>) addressDAOImpl.findAll();
	}

	@Override
	public List<Address> getAllShippingAddresses(Long userId) {
		return ((AddressDAO)addressDAOImpl).getAllShippingAddress(userId);
	}

	@Override
	public List<Address> getAllBillingAddresses(Long userId) {
		return ((AddressDAO)addressDAOImpl).getAllBillingAddress(userId);
	}

	@Override
	public boolean updateCart(ShoppingCart shoppingCart) {
		return shoppingCartDAOImpl.update(shoppingCart);
	}

}
