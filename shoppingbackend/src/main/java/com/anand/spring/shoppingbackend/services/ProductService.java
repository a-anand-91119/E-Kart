package com.anand.spring.shoppingbackend.services;

import java.util.List;

import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.dto.ProductWallpapersData;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;

/**
 * 
 * @author A Anand
 *
 */
public interface ProductService {
	
	public List<ProductDataForAllProducts> getAllActiveProducts();
	
	public List<ProductDataForAllProducts> getAllActiveProductsByCategory(Long categoryId); 
	
	public List<ProductDataForAllProducts> getLatestActiveProducts(Integer count); 
	
	public List<ProductWallpapersData> getHighestRatedProductWallpapers();

	public ProductData getProduct(String productCode) throws InvalidProductCodeException;
}
