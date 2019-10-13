package com.anand.spring.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements DAO{

	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(Object id) {
		return new Category(1, "categoryName", "categoryDescription", "categoryImageUrl", true);
	}

	@Override
	public List<?> findAll() {
		return new ArrayList<Category>() {{
			add(new Category(0, "categoryName", "categoryDescription", "categoryImageUrl", true));
			add(new Category(1, "categoryName", "categoryDescription", "categoryImageUrl", true));
		}};
	}

	@Override
	public List<?> findByProperty(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMultiple(Object[] ids) {
		// TODO Auto-generated method stub
		
	}

}
