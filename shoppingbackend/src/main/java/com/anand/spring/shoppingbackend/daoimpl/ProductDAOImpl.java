package com.anand.spring.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anand.spring.shoppingbackend.dao.ProductDAO;
import com.anand.spring.shoppingbackend.entities.Product;
import com.anand.spring.shoppingbackend.exceptions.InvalidIdException;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Object object) {
		try {
			sessionFactory.getCurrentSession().persist((Product)object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Object object) {
		try {
			sessionFactory.getCurrentSession().update((Product)object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(Object object) {
		Product product = (Product) object;
		product.setProductIsActive(false);
		
		try {
			sessionFactory.getCurrentSession().update((Product)product);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Object id) throws InvalidIdException {
		Product product = (Product) findById(id);
		
		if(product != null)
			delete(product);
		else
			throw new InvalidIdException("No Products Found with Id: " + id);
	}

	@Override
	public Object findById(Object id) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, (Long)id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		String activeCategoryQuery = "FROM Product WHERE productIsActive = :active";
		
		Query<?> query = sessionFactory.getCurrentSession().createQuery(activeCategoryQuery);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {
		
		String customQuery = "FROM Product WHERE productIsActive = :active AND " + propertyName + " = :value";
		
		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("value", propertyValue);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public void deleteMultiple(Object[] ids) throws InvalidIdException {
		
		for(Object id : ids)
			deleteById(id);
	}

	@Override
	public List<?> findXAlls(Integer maxResults) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE productIsActive = :active ORDER BY productId", Product.class)
				.setParameter("active", true).setMaxResults(maxResults).getResultList();
	}

	@Override
	public List<?> findTopRated(Integer count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE productIsActive = :active ORDER BY productViews, productPurchases", Product.class)
				.setParameter("active", true).setMaxResults(count).getResultList();
	}

}
