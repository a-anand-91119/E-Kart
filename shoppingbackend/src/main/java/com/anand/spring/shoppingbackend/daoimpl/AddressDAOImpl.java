package com.anand.spring.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anand.spring.shoppingbackend.dao.AddressDAO;
import com.anand.spring.shoppingbackend.entities.Address;
import com.anand.spring.shoppingbackend.exceptions.InvalidAddressIdException;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(Object object) {
		try {
			sessionFactory.getCurrentSession().persist((Address) object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Object object) {
		try {
			sessionFactory.getCurrentSession().update((Address) object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void delete(Object object) {
		try {
			sessionFactory.getCurrentSession().delete((Address) object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Object id) throws InvalidAddressIdException {

		Address address = (Address) findById(id);

		if (address != null)
			delete(address);
		else
			throw new InvalidAddressIdException("No Categories Found with Id: " + id);
	}

	@Override
	public Object findById(Object id) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, (Long) id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<?> findAll() {
		String activeCategoryQuery = "FROM Address";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(activeCategoryQuery);

		return query.getResultList();
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {

		String customQuery = "FROM Address WHERE " + propertyName + " = :value";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("value", propertyValue);

		return query.getResultList();
	}

	@Override
	public void deleteMultiple(Object[] ids) throws InvalidAddressIdException {

		for (Object id : ids)
			deleteById(id);
	}

	@Override
	public List<Address> getAllShippingAddress(Long userId) {
		String customQuery = "FROM Address WHERE addressUserId = :userId AND addressShipping = true";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("userId", userId);

		return (List<Address>) query.getResultList();
	}

	@Override
	public List<Address> getAllBillingAddress(Long userId) {
		String customQuery = "FROM Address WHERE addressUserId = :userId AND addressBilling = true";

		Query<?> query = sessionFactory.getCurrentSession().createQuery(customQuery);
		query.setParameter("userId", userId);

		return (List<Address>) query.getResultList();
	}

}
