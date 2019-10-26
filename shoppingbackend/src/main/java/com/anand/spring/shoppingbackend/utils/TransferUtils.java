package com.anand.spring.shoppingbackend.utils;

import java.util.ArrayList;
import java.util.List;

import com.anand.spring.shoppingbackend.dto.AddressTO;
import com.anand.spring.shoppingbackend.dto.CategoryData;
import com.anand.spring.shoppingbackend.dto.CategoryHome;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.dto.ProductAdminData;
import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.dto.ProductWallpapersData;
import com.anand.spring.shoppingbackend.dto.UserRegister;
import com.anand.spring.shoppingbackend.entities.Address;
import com.anand.spring.shoppingbackend.entities.Category;
import com.anand.spring.shoppingbackend.entities.Product;
import com.anand.spring.shoppingbackend.entities.ShoppingCart;
import com.anand.spring.shoppingbackend.entities.User;

/**
 * The Class TransferUtils performs all the converstion from Entities into Data
 * Transfer Objects
 * 
 * @author A Anand
 *
 */
public class TransferUtils {

	public static List<CategoryHome> getCategoryForHomePage(List<Category> categoryDatas) {

		List<CategoryHome> returnCategoryHomes = new ArrayList<CategoryHome>();

		if (categoryDatas != null)
			for (Category category : categoryDatas) {

				CategoryHome categoryHome = new CategoryHome();
				categoryHome.setCategoryId(category.getCategoryId());
				if (category.getCategoryDescription().length() > 100)
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

	public static List<ProductDataForAllProducts> getProductDataForAllProducts(List<Product> products) {

		List<ProductDataForAllProducts> productReturn = new ArrayList<ProductDataForAllProducts>();

		if (products != null)
			for (Product product : products) {

				ProductDataForAllProducts productDataForAllProducts = new ProductDataForAllProducts();
				productDataForAllProducts.setProductCode(product.getProductCode());
				productDataForAllProducts.setProductDescription(product.getProductDescription());
				productDataForAllProducts
						.setProductName(product.getProductName() + "#####" + product.getProductDescription());
				productDataForAllProducts.setProductOverallRating(
						computeOveralllRating(product.getProductRating1(), product.getProductRating2(),
								product.getProductRating3(), product.getProductRating4(), product.getProductRating5()));
				productDataForAllProducts.setProductThumbnailUrl(product.getProductPortraitUrl());
				productDataForAllProducts.setProductUnitCost(product.getProductUnitPrice());
				productDataForAllProducts.setProductQuantity(product.getProductQuantity());

				productReturn.add(productDataForAllProducts);
			}

		return productReturn;
	}

	/**
	 * Method Computes the overall rating of a product from the individual star
	 * ratings. The method computes the weighted average, where the method weighs
	 * each rating with the number of votes it gets. If a product has no ratings,
	 * then the overall rating would be 0
	 * 
	 * @param productRating1 number of 1 star ratings
	 * @param productRating2 number of 2 star ratings
	 * @param productRating3 number of 3 star ratings
	 * @param productRating4 number of 4 star ratings
	 * @param productRating5 number of 5 star ratings
	 * @return the overall rating of a product
	 */
	private static Integer computeOveralllRating(Integer productRating1, Integer productRating2, Integer productRating3,
			Integer productRating4, Integer productRating5) {

		if ((productRating5 + productRating4 + productRating3 + productRating2 + productRating1) == 0)
			return 0;

		return ((5 * productRating5) + (4 * productRating4) + (3 * productRating3) + (2 * productRating2)
				+ (1 * productRating1))
				/ (productRating5 + productRating4 + productRating3 + productRating2 + productRating1);
	}

	public static List<CategorySideBarData> getCategorySideBarDatas(List<Category> categoryDatas) {

		List<CategorySideBarData> returnCategoryHomes = new ArrayList<CategorySideBarData>();

		if (categoryDatas != null)
			for (Category category : categoryDatas) {

				CategorySideBarData categorySideBarData = new CategorySideBarData();
				categorySideBarData.setCategoryId(category.getCategoryId());
				categorySideBarData.setCategoryName(category.getCategoryName());

				returnCategoryHomes.add(categorySideBarData);
			}

		return returnCategoryHomes;
	}

	public static List<ProductWallpapersData> getTopProductImages(List<Product> fetchedProducts) {

		List<ProductWallpapersData> returnProductWallpaperDatas = new ArrayList<ProductWallpapersData>();

		if (fetchedProducts != null)
			for (Product product : fetchedProducts) {

				ProductWallpapersData productWallpapersData = new ProductWallpapersData();
				productWallpapersData.setProductCategory(product.getProductCategoryId());
				productWallpapersData.setProductCode(product.getProductCode());
				productWallpapersData.setProductImageUrl(product.getProductLandscapeUrl());
				if (product.getProductSpecs() != null && !product.getProductSpecs().isEmpty())
					productWallpapersData
							.setProductName(product.getProductName() + "(" + product.getProductSpecs() + ")");
				else
					productWallpapersData.setProductName(product.getProductName());

				returnProductWallpaperDatas.add(productWallpapersData);
			}

		return returnProductWallpaperDatas;
	}

	public static ProductData getProductDataForProductDetailsPage(Product product) {
		ProductData productData = new ProductData();
		productData.setProductBrand(product.getProductBrand());
		productData.setProductCode(product.getProductCode());
		productData.setProductCategoryId(product.getProductCategoryId());
		productData.setProductDescription(product.getProductDescription());
		productData.setProductId(product.getProductId());
		productData.setProductLandscapeUrl(product.getProductLandscapeUrl());
		if (product.getProductSpecs() != null && !product.getProductSpecs().isEmpty())
			productData.setProductName(product.getProductName() + " (" + product.getProductSpecs() + ")");
		else
			productData.setProductName(product.getProductName());
		productData
				.setProductOverallrating(computeOveralllRating(product.getProductRating1(), product.getProductRating2(),
						product.getProductRating3(), product.getProductRating4(), product.getProductRating5()));
		productData.setProductPurchases(product.getProductPurchases());
		productData.setProductRating1(product.getProductRating1());
		productData.setProductRating2(product.getProductRating2());
		productData.setProductRating3(product.getProductRating3());
		productData.setProductRating4(product.getProductRating4());
		productData.setProductRating5(product.getProductRating5());
		productData.setProductUnitPrice(product.getProductUnitPrice());
		productData.setProductViews(product.getProductViews());
		productData.setProductQuantity(product.getProductQuantity());
		return productData;
	}

	public static Product getProductEntityToCreate(ProductData productData, boolean isDefaultNeeded) {
		Product product = new Product();
		product.setProductBrand(productData.getProductBrand());
		product.setProductCategoryId(productData.getProductCategoryId());
		product.setProductCode(productData.getProductCode());
		product.setProductDescription(productData.getProductDescription());
		product.setProductIsActive(true);
		product.setProductName(productData.getProductName());
		product.setProductLandscapeUrl(productData.getProductLandscapeUrl());
		product.setProductPortraitUrl(productData.getProductPortraitUrl());
		product.setProductQuantity(productData.getProductQuantity());
		product.setProductSpecs(productData.getProductSpecification());
		product.setProductSupplierId(productData.getProductSupplierId());
		product.setProductUnitPrice(productData.getProductUnitPrice());
		if (isDefaultNeeded)
			product.setDefaults();
		else {
			product.setProductId(productData.getProductId());
			product.setProductOverallrating(productData.getProductOverallrating());
			product.setProductRating1(productData.getProductRating1());
			product.setProductRating2(productData.getProductRating2());
			product.setProductRating3(productData.getProductRating3());
			product.setProductRating4(productData.getProductRating4());
			product.setProductRating5(productData.getProductRating5());
			product.setProductPurchases(productData.getProductPurchases());
			product.setProductViews(productData.getProductViews());
		}

		return product;
	}

	public static List<ProductAdminData> getAllProductsForAdmin(List<Product> fetchedData) {
		List<ProductAdminData> productReturn = new ArrayList<ProductAdminData>();

		if (fetchedData != null)
			for (Product product : fetchedData) {

				ProductAdminData productAdminData = new ProductAdminData();
				productAdminData.setProductCode(product.getProductCode());
				productAdminData.setProductDescription(product.getProductDescription());
				productAdminData.setProductName(product.getProductName());
				productAdminData.setProductOverallrating(
						computeOveralllRating(product.getProductRating1(), product.getProductRating2(),
								product.getProductRating3(), product.getProductRating4(), product.getProductRating5()));
				productAdminData.setProductPortraitUrl(product.getProductPortraitUrl());
				productAdminData.setProductLandscapeUrl(product.getProductLandscapeUrl());
				productAdminData.setProductUnitPrice(product.getProductUnitPrice());
				productAdminData.setProductQuantity(product.getProductQuantity());
				productAdminData.setProductBrand(product.getProductBrand());
				productAdminData.setProductCategoryId(product.getProductCategoryId());
				productAdminData.setProductId(product.getProductId());
				productAdminData.setProductSupplierId(product.getProductSupplierId());
				productAdminData.setProductIsActive(product.getProductIsActive());
				productAdminData.setProductSpecification(product.getProductSpecs());
				productReturn.add(productAdminData);
			}

		return productReturn;
	}

	public static ProductData getProductDataForEdit(Product product) {
		ProductData productData = new ProductData();
		productData.setProductBrand(product.getProductBrand());
		productData.setProductSupplierId(product.getProductSupplierId());
		productData.setProductCode(product.getProductCode());
		productData.setProductCategoryId(product.getProductCategoryId());
		productData.setProductDescription(product.getProductDescription());
		productData.setProductId(product.getProductId());
		productData.setProductLandscapeUrl(product.getProductLandscapeUrl());
		productData.setProductPortraitUrl(product.getProductPortraitUrl());
		productData.setProductName(product.getProductName());
		productData.setProductSpecification(product.getProductSpecs());
		productData.setProductPurchases(product.getProductPurchases());
		productData.setProductRating1(product.getProductRating1());
		productData.setProductRating2(product.getProductRating2());
		productData.setProductRating3(product.getProductRating3());
		productData.setProductRating4(product.getProductRating4());
		productData.setProductRating5(product.getProductRating5());
		productData.setProductUnitPrice(product.getProductUnitPrice());
		productData.setProductViews(product.getProductViews());
		productData.setProductQuantity(product.getProductQuantity());
		return productData;
	}

	public static Category getCategoryForDbInsert(CategoryData categoryData) {
		Category category = new Category();
		category.setCategoryDescription(categoryData.getCategoryDescription());
		category.setCategoryName(categoryData.getCategoryName());
		category.setCategoryThumbnailURL(categoryData.getCategoryThumbnailUrl());
		return category;
	}

	public static User createUserEntity(UserRegister userRegister) {
		User user = new User();
		user.setUserRole(userRegister.getUserRole());
		if(user.getUserRole().equals(Constants.ROLE_USER)) {
			ShoppingCart shoppingCart = new ShoppingCart();
			user.setShoppingCart(shoppingCart);
			shoppingCart.setUser(user);
		}
		user.setUserPassword(userRegister.getUserPassword());
		user.setUserEmailAddress(userRegister.getUserEmailAddress());
		user.setUserFirstName(userRegister.getUserFirstName());
		user.setUserLastName(userRegister.getUserLastName());
		user.setUserPhoneNumber(userRegister.getUserPhoneNumber());
		return user;
	}

	public static Address createAddressEntity(AddressTO addressToSave, Long userId) {
		Address address = new Address();
		address.setAddressCity(addressToSave.getAddressCity());
		address.setAddressPostalCode(addressToSave.getAddressPostalCode());
		address.setAddressLineTwo(addressToSave.getAddressLineTwo());
		address.setAddressBilling(addressToSave.getAddressBilling());
		address.setAddressShipping(addressToSave.getAddressShipping());
		address.setAddressUserId(userId);
		address.setAddressState(addressToSave.getAddressState());
		address.setAddressCountry(addressToSave.getAddressCountry());
		address.setAddressLineOne(addressToSave.getAddressLineOne());
		return address;
	}
}
