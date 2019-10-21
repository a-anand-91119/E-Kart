package com.anand.spring.shoppingbackend.serviceimpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.anand.spring.shoppingbackend.dao.DAO;
import com.anand.spring.shoppingbackend.dao.ProductDAO;
import com.anand.spring.shoppingbackend.dto.ProductAdminData;
import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.dto.ProductDataForAllProducts;
import com.anand.spring.shoppingbackend.dto.ProductWallpapersData;
import com.anand.spring.shoppingbackend.entities.Product;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;
import com.anand.spring.shoppingbackend.services.ProductService;
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
		Product product = TransferUtils.getProductEntityToCreate(productData, true);
		productDAOImpl.save(product);
	}

	@Override
	public List<ProductAdminData> getAllProductsForAdmin() {
		List<Product> fetchedData = (List<Product>) ((ProductDAO)productDAOImpl).findAllForAdmin();
		return TransferUtils.getAllProductsForAdmin(fetchedData);
	}

	@Override
	public Boolean changeProductStatus(String productCode) throws InvalidProductCodeException {
		Product fetchedProduct = ((ProductDAO)productDAOImpl).findAllByCode(productCode);
		fetchedProduct.setProductIsActive(!fetchedProduct.getProductIsActive());
		return productDAOImpl.update(fetchedProduct);
	}

	@Override
	public ProductData getProductForEdit(String productCode) throws InvalidProductCodeException {
		Product product = ((ProductDAO)productDAOImpl).findByCode(productCode);
		return TransferUtils.getProductDataForEdit(product);
	}

	@Override
	public void updateProduct(@Valid ProductData productData) {
		Product product = TransferUtils.getProductEntityToCreate(productData, false);
		productDAOImpl.update(product);
	}

}
