package com.anand.spring.shoppingbackend.services;

import java.util.List;

import com.anand.spring.shoppingbackend.dto.CategoryData;
import com.anand.spring.shoppingbackend.dto.CategoryHome;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.exceptions.InvalidIdException;

public interface CategoryService {

	/**
	 * Method returns Category Datas - Name, Description, Thumbnail URL
	 * 
	 * @return
	 * 		a list of {@link CategoryHome}
	 */
	public List<CategoryHome> getCategoryPreview();
	
	/**
	 * Finds and returns a particular category based on the input category Id
	 * 
	 * @param categoryId
	 * 			the category Id of the target category
	 * @return
	 * 			A {@link CategoryData} object
	 */
	public CategoryHome findCategoryById(Long categoryId) throws InvalidIdException;
	
	/**
	 * Method returns CategorySideBarData - Category Id and Category Name
	 * 
	 * @return
	 * 		a list of {@link CategorySideBarData}
	 */
	public List<CategorySideBarData> getSideBarCategories();
}
