package com.anand.spring.shoppingbackend.dao;

import java.util.List;

import com.anand.spring.shoppingbackend.entities.Address;

/**
 * 
 * @author A Anand
 *
 */
public interface AddressDAO extends DAO {

	public List<Address> getAllShippingAddress(Long userId);

	public List<Address> getAllBillingAddress(Long userId);
}
