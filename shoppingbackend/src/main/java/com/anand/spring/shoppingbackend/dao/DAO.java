package com.anand.spring.shoppingbackend.dao;

import java.util.List;

import com.anand.spring.shoppingbackend.exceptions.InvalidCategoryIdException;
import com.anand.spring.shoppingbackend.exceptions.InvalidIdException;

/**
 * 
 * @author A Anand
 *
 */
public interface DAO {

	public boolean save(Object object);

	public boolean update(Object object);

	public void delete(Object object);

	public void deleteById(Object id) throws InvalidIdException;

	public Object findById(Object id);

	public List<?> findAll();

	public List<?> findByProperty(String propertyName, Object propertyValue);
	
	public void deleteMultiple(Object[] ids) throws InvalidIdException;
}
