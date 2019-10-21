package com.anand.spring.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.shoppingbackend.dto.ProductAdminData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.services.ProductService;

/**
 * 
 * @author A Anand
 *
 */
@Controller
@RequestMapping(value = {Constants.URL_JSON_DATA})
public class JsonDataController {

	@Autowired
	private ProductService productServiceImpl;
	
	@RequestMapping(value = {Constants.URL_ALL_PRODUCTS})
	@ResponseBody
	public List<ProductDataForAllProducts> getAllProducts(){
		return productServiceImpl.getAllActiveProducts();
	}
	
	@RequestMapping(value = {Constants.URL_CATEGORY_PRODUCTS})
	@ResponseBody
	public List<ProductDataForAllProducts> getAllProducts(@PathVariable(name = "categoryId") Long categoryId){
		return productServiceImpl.getAllActiveProductsByCategory(categoryId);
	}
	
	@RequestMapping(value = {Constants.URL_MANAGE_PRODUCTS})
	@ResponseBody
	public List<ProductAdminData> getAllProductsForAdmin(){
		return productServiceImpl.getAllProductsForAdmin();
	}
}
