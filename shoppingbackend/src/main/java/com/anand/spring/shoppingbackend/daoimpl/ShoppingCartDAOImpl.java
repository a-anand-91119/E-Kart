package com.anand.spring.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.ShoppingCart;
import com.anand.spring.shoppingbackend.exceptions.InvalidShoppingCartIdException;

/**
 * 
 * @author A Anand
 *
 */
@Repository
@Transactional
public class ShoppingCartDAOImpl implements DAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Object object) {
		try {
			sessionFactory.getCurrentSession().persist((ShoppingCart) object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Object object) {
		try {
			sessionFactory.getCurrentSession().update((ShoppingCart) object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(Object object) {
		try {
			sessionFactory.getCurrentSession().delete((ShoppingCart) object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Object id) throws InvalidShoppingCartIdException {

		ShoppingCart shoppingCart = (ShoppingCart) findById(id);

		if (shoppingCart != null)
			delete(shoppingCart);
		else
			throw new InvalidShoppingCartIdException("No Categories Found with Id: " + id);
	}

	@Override
	public Object findById(Object id) {
		try {
			return sessionFactory.getCurrentSession().get(ShoppingCart.class, (Long) id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		String activeCategoryQuery = "FROM ShoppingCart";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(activeCategoryQuery);

		return query.getResultList();
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {

		String customQuery = "FROM ShoppingCart WHERE " + propertyName + " = :value";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("value", propertyValue);

		return query.getResultList();
	}

	@Override
	public void deleteMultiple(Object[] ids) throws InvalidShoppingCartIdException {

		for (Object id : ids)
			deleteById(id);
	}

}
