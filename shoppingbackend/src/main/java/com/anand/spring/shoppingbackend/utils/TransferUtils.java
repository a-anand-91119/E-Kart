package com.anand.spring.shoppingbackend.utils;

import java.util.ArrayList;
import java.util.List;

import com.anand.spring.shoppingbackend.dto.CategoryHome;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.dto.ProductWallpapersData;
import com.anand.spring.shoppingbackend.entities.Category;
import com.anand.spring.shoppingbackend.entities.Product;

/**
 * The Class TransferUtils performs all the converstion from Entities into Data Transfer Objects
 * 
 * @author A Anand
 *
 */
public class TransferUtils {

	public static List<CategoryHome> getCategoryForHomePage(List<Category> categoryDatas) {
		
		List<CategoryHome> returnCategoryHomes = new ArrayList<CategoryHome>();
		
		if(categoryDatas != null)
			for(Category category : categoryDatas) {
				
				CategoryHome categoryHome = new CategoryHome();
				categoryHome.setCategoryId(category.getCategoryId());
				if(category.getCategoryDescription().length() > 100)
					categoryHome.setCategoryDescription(category.getCategoryDescription().substring(0, 100) + "...");
				else
					categoryHome.setCategoryDescription(category.getCategoryDescription());
				categoryHome.setCategoryName(category.getCategoryName());
				categoryHome.setCategoryThumbnailUrl(category.getCategoryThumbnailURL());
				
				returnCategoryHomes.add(categoryHome);
			}
		
		return returnCategoryHomes;
	}

	public static CategoryHome getFullCategoryData(Category category) {
		
		CategoryHome categoryHome = new CategoryHome();
		categoryHome.setCategoryId(category.getCategoryId());
		categoryHome.setCategoryDescription(category.getCategoryDescription().substring(0, 30) + "...");
		categoryHome.setCategoryName(category.getCategoryName());
		categoryHome.setCategoryThumbnailUrl(category.getCategoryThumbnailURL());
		
		return categoryHome;
	}
	
	public static List<ProductDataForAllProducts> getProductDataForAllProducts(List<Product> products){
		
		List<ProductDataForAllProducts> productReturn = new ArrayList<ProductDataForAllProducts>();
		
		if(products != null)		
			for(Product product : products) {
				
				ProductDataForAllProducts productDataForAllProducts = new ProductDataForAllProducts();
				productDataForAllProducts.setProductCode(product.getProductCode());
				productDataForAllProducts.setProductDescription(product.getProductDescription());
				productDataForAllProducts.setProductName(product.getProductName());
				productDataForAllProducts.setProductOverallRating(
						computeOveralllRating(product.getProductRating1(),
								product.getProductRating2(),
								product.getProductRating3(),
								product.getProductRating4(),
								product.getProductRating5()));
				productDataForAllProducts.setProductThumbnailUrl(product.getProductPortraitUrl());
				productDataForAllProducts.setProductUnitCost(product.getProductUnitPrice());
				
				productReturn.add(productDataForAllProducts);
			}
		
		return productReturn;
	}

	/**
	 * Method Computes the overall rating of a product from the individual star ratings. 
	 * The method computes the weighted average, where the method weighs each rating with the number of votes it gets.
	 * If a product has no ratings, then the overall rating would be 0
	 * 
	 * @param productRating1
	 * 			number of 1 star ratings
	 * @param productRating2
	 * 			number of 2 star ratings
	 * @param productRating3
	 * 			number of 3 star ratings
	 * @param productRating4
	 * 			number of 4 star ratings
	 * @param productRating5
	 * 			number of 5 star ratings
	 * @return
	 * 			the overall rating of a product
	 */
	private static Integer computeOveralllRating(Integer productRating1, Integer productRating2, Integer productRating3,
			Integer productRating4, Integer productRating5) {
		
		if((productRating5 + productRating4 + productRating3 + productRating2 + productRating1) == 0)
			return 0;
		
		return ( (5 * productRating5) +
				(4 * productRating4) +
				(3 * productRating3) +
				(2 * productRating2) +
				(1 * productRating1) ) / ( productRating5 + productRating4 + productRating3 + productRating2 + productRating1);
	}

	public static List<CategorySideBarData> getCategorySideBarDatas(List<Category> categoryDatas) {
		
		List<CategorySideBarData> returnCategoryHomes = new ArrayList<CategorySideBarData>();
		
		if(categoryDatas != null)
			for(Category category : categoryDatas) {
				
				CategorySideBarData categorySideBarData = new CategorySideBarData();
				categorySideBarData.setCategoryId(category.getCategoryId());
				categorySideBarData.setCategoryName(category.getCategoryName());
				
				returnCategoryHomes.add(categorySideBarData);
			}
		
		return returnCategoryHomes;
	}

	public static List<ProductWallpapersData> getTopProductImages(List<Product> fetchedProducts) {
		
		List<ProductWallpapersData> returnProductWallpaperDatas = new ArrayList<ProductWallpapersData>();
		
		if(fetchedProducts != null)
			for(Product product : fetchedProducts) {
				
				ProductWallpapersData productWallpapersData = new ProductWallpapersData();
				productWallpapersData.setProductCategory(product.getProductCategoryId());
				productWallpapersData.setProductCode(product.getProductCode());
				productWallpapersData.setProductImageUrl(product.getProductLandscapeUrl());
				if(product.getProductSpecs() != null && !product.getProductSpecs().isEmpty())
					productWallpapersData.setProductName(product.getProductName() + "(" + product.getProductSpecs() + ")");
				else
					productWallpapersData.setProductName(product.getProductName());
				
				returnProductWallpaperDatas.add(productWallpapersData);
			}
		
		return returnProductWallpaperDatas;
	}
}
