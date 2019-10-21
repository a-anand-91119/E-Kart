package com.anand.spring.shoppingbackend.dao;

import java.util.List;

import com.anand.spring.shoppingbackend.entities.Product;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;

/**
 * 
 * @author A Anand
 *
 */
public interface ProductDAO extends DAO {

	public List<?> findXAlls(Integer count);

	public List<?> findTopRated(Integer count);
	
	public Product findByCode(String productCode) throws InvalidProductCodeException;

	public List<?> findAllForAdmin();

	public Product findAllByCode(String productCode) throws InvalidProductCodeException;
}
