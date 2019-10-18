package com.anand.spring.shoppingbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.dao.ProductDAO;
import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.dto.ProductWallpapersData;
import com.anand.spring.shoppingbackend.entities.Product;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;
import com.anand.spring.shoppingbackend.utils.TransferUtils;

@Service
@SuppressWarnings("unchecked")
/**
 * 
 * @author A Anand
 *
 */
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier(value = "productDAOImpl")
	private DAO productDAOImpl;
	
	@Override
	public List<ProductDataForAllProducts> getAllActiveProducts() {
		List<Product> fetchedProducts = (List<Product>) productDAOImpl.findAll();
		return TransferUtils.getProductDataForAllProducts(fetchedProducts);
	}

	@Override
	public List<ProductDataForAllProducts> getAllActiveProductsByCategory(Long categoryId) {
		List<Product> fetchedProducts = (List<Product>) productDAOImpl.findByProperty("productCategoryId", categoryId);
		return TransferUtils.getProductDataForAllProducts(fetchedProducts);
	}

	@Override
	public List<ProductDataForAllProducts> getLatestActiveProducts(Integer count) {
		List<Product> fetchedProducts = (List<Product>) ((ProductDAO)productDAOImpl).findXAlls(count);
		return TransferUtils.getProductDataForAllProducts(fetchedProducts);
	}

	@Override
	public List<ProductWallpapersData> getHighestRatedProductWallpapers() {
		List<Product> fetchedProducts = (List<Product>) ((ProductDAO)productDAOImpl).findTopRated(5);
		return TransferUtils.getTopProductImages(fetchedProducts);
	}

	@Override
	public ProductData getProduct(String productCode) throws InvalidProductCodeException {		
		Product product = ((ProductDAO)productDAOImpl).findByCode(productCode);
		
		product.setProductViews(product.getProductViews() + 1);
		productDAOImpl.update(product);

		return TransferUtils.getProductDataForProductDetailsPage(product);
	}

	@Override
	public void createProduct(ProductData productData) {
		Product product = TransferUtils.getProductEntityToCreate(productData);
		productDAOImpl.save(product);
	}

}
