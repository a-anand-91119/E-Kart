package com.anand.spring.shoppingbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.dto.CategoryHome;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.entities.Category;
import com.anand.spring.shoppingbackend.exceptions.InvalidCategoryIdException;
import com.anand.spring.shoppingbackend.utils.TransferUtils;

@Service
@SuppressWarnings("unchecked")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier(value = "categoryDAOImpl")
	private DAO categoryDAOImpl;

	@Override
	public List<CategoryHome> getCategoryPreview() {
		
		List<Category> categoryDatas = (List<Category>) categoryDAOImpl.findAll();
		return TransferUtils.getCategoryForHomePage(categoryDatas);
	}

	@Override
	public CategoryHome findCategoryById(Long categoryId) throws InvalidCategoryIdException{
		
		Object category = categoryDAOImpl.findById(categoryId);
		if(category == null)
			throw new InvalidCategoryIdException("No Categories Found with Id: " + categoryId);
		
		return TransferUtils.getFullCategoryData((Category) category);
	}

	@Override
	public List<CategorySideBarData> getSideBarCategories() {
		List<Category> categoryDatas = (List<Category>) categoryDAOImpl.findAll();
		return TransferUtils.getCategorySideBarDatas(categoryDatas);
	}

}
