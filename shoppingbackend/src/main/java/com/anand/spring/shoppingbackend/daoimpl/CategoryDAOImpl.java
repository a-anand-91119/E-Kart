package com.anand.spring.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.Category;
import com.anand.spring.shoppingbackend.exceptions.InvalidIdException;

@Repository
@Transactional
public class CategoryDAOImpl implements DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Object object) {
		try {
			sessionFactory.getCurrentSession().persist((Category)object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Object object) {
		try {
			sessionFactory.getCurrentSession().update((Category)object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(Object object) {
		Category category = (Category) object;
		category.setCategoryIsActive(false);
		
		try {
			sessionFactory.getCurrentSession().update((Category)category);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Object id) throws InvalidIdException {
		
		Category category = (Category) findById(id);
		
		if(category != null)
			delete(category);
		else
			throw new InvalidIdException("No Categories Found with Id: " + id);
	}

	@Override
	public Object findById(Object id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, (Long)id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		String activeCategoryQuery = "FROM Category WHERE categoryIsActive = :active";
		
		Query<?> query = sessionFactory.getCurrentSession().createQuery(activeCategoryQuery);
		query.setParameter("active", true);
		
		return query.getResultList();
	}
	
	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {
		
		String customQuery = "FROM Category WHERE " + propertyName + " = :value";
		
		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("value", propertyValue);
		
		return query.getResultList();
	}

	@Override
	public void deleteMultiple(Object[] ids) throws InvalidIdException {
		
		for(Object id : ids)
			deleteById(id);
	}

}
