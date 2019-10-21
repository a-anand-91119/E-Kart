package com.anand.spring.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.entities.User;
import com.anand.spring.shoppingbackend.exceptions.InvalidUserIdException;

/**
 * 
 * @author A Anand
 *
 */
@Repository
@Transactional
public class UserDAOImpl implements DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Object object) {
		try {
			sessionFactory.getCurrentSession().persist((User) object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Object object) {
		try {
			sessionFactory.getCurrentSession().update((User) object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(Object object) {
		User user = (User) object;
		user.setUserIsEnabled(false);

		try {
			sessionFactory.getCurrentSession().update((User) user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Object id) throws InvalidUserIdException {

		User user = (User) findById(id);

		if (user != null)
			delete(user);
		else
			throw new InvalidUserIdException("No Categories Found with Id: " + id);
	}

	@Override
	public Object findById(Object id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, (Long) id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		String activeCategoryQuery = "FROM User WHERE userIsEnabled = :active";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(activeCategoryQuery);
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {

		String customQuery = "FROM User WHERE " + propertyName + " = :value";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("value", propertyValue);

		return query.getResultList();
	}

	@Override
	public void deleteMultiple(Object[] ids) throws InvalidUserIdException {

		for (Object id : ids)
			deleteById(id);
	}

}
