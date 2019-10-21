package com.anand.spring.onlineshopping.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.spring.onlineshopping.configuration.SpringLogger;
import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.onlineshopping.utils.FileUploadUtil;
import com.anand.spring.onlineshopping.validator.ProductValidator;
import com.anand.spring.shoppingbackend.dto.CategoryData;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;
import com.anand.spring.shoppingbackend.services.CategoryService;
import com.anand.spring.shoppingbackend.services.ProductService;

/**
 * 
 * @author A Anand
 *
 */
@Controller
@RequestMapping(value = { Constants.URL_MANAGEMENT })
public class ManagementController {

	@Autowired
	private CategoryService categoryServiceImpl;
	@Autowired
	private ProductValidator productValidator;
	@Autowired
	private ProductService productServiceImpl;
	@Autowired
	private SpringLogger springLogger;

	@RequestMapping(value = { Constants.URL_MANAGE_PRODUCT }, method = RequestMethod.GET)
	public String manageProducts(Model model, @RequestParam(name = "operation", required = false) String operation) {
		model.addAttribute("userClickedOption", "manageProduct");
		model.addAttribute("title", "Manage Products");
		model.addAttribute("menu", "manageProducts");
		model.addAttribute("createNewCategory", new CategoryData());
		if (operation != null)
			if (operation.equals(Constants.PRODUCT_SAVE_SUCCESS))
				model.addAttribute("message", "insertSuccess");
			else if (operation.equals(Constants.PRODUCT_UPDATE_SUCCESS))
				model.addAttribute("message", "updateSuccess");
			else if (operation.equals(Constants.CATEGORY_SAVE_FAIL))
				model.addAttribute("message", "categorySaveFailed");
			else if (operation.equals(Constants.CATEGORY_SAVE_SUCCESS))
				model.addAttribute("message", "categorySaveSuccess");
		return "master";
	}

	@ModelAttribute("categories")
	public List<CategorySideBarData> getAllCategories() {
		return categoryServiceImpl.getSideBarCategories();
	}

	@RequestMapping(value = { Constants.URL_SAVE_PRODUCT,
			Constants.URL_SAVE_UPDATE_PRODUCT }, method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("productData") ProductData productData,
			BindingResult bindingResult, Model model, HttpServletRequest httpServletRequest) {

		if (productData.getProductId() == null || productData.getProductId() == 0)
			productValidator.validate(productData, bindingResult);
		else {
			uploadImages(productData, httpServletRequest);
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickedOption", "manageProduct");
			model.addAttribute("title", "Manage Products");
			model.addAttribute("menu", "manageProducts");
			return "master";
		}

		model.addAttribute("userClickedOption", "manageProduct");
		model.addAttribute("title", "Manage Products");
		model.addAttribute("menu", "manageProducts");

		if (productData.getProductId() == null || productData.getProductId() == 0) {
			productData.setProductSupplierId(new Long(2));
			springLogger.getLogger().info("Created Product: " + productData);

			uploadImages(productData, httpServletRequest);

			productServiceImpl.createProduct(productData);

			return "redirect:/" + Constants.URL_MANAGEMENT + Constants.URL_MANAGE_PRODUCT + "?operation="
					+ Constants.PRODUCT_SAVE_SUCCESS;
		} else {
			productServiceImpl.updateProduct(productData);

			return "redirect:/" + Constants.URL_MANAGEMENT + Constants.URL_MANAGE_PRODUCT + "?operation="
					+ Constants.PRODUCT_UPDATE_SUCCESS;
		}
	}

	@RequestMapping(value = { Constants.URL_PRODUCT_STATUS_CHANGE }, method = RequestMethod.POST)
	@ResponseBody
	public Boolean changeProductStatus(@PathVariable(name = "productCode") String productCode)
			throws InvalidProductCodeException {
		Boolean changeStatus = productServiceImpl.changeProductStatus(productCode);
		if (changeStatus)
			return true;
		else
			return false;
	}

	@RequestMapping(value = { Constants.URL_EDIT_PRODUCT })
	public String editProduct(@PathVariable(name = "productCode") String productCode, Model model)
			throws InvalidProductCodeException {
		model.addAttribute("userClickedOption", "editProduct");
		model.addAttribute("title", "Edit Products");
		model.addAttribute("menu", "manageProducts");
		ProductData productData = productServiceImpl.getProductForEdit(productCode);
		model.addAttribute("productData", productData);
		return "master";
	}

	@RequestMapping(value = { Constants.URL_ADD_CATEGORY }, method = RequestMethod.POST)
	public String createCategory(@ModelAttribute(name = "createNewCategory") CategoryData categoryData, Model model,
			HttpServletRequest httpServletRequest) {

		if (categoryData.getCategoryThumbnail() != null
				&& !categoryData.getCategoryThumbnail().getOriginalFilename().isEmpty()) {
			FileUploadUtil.uploadFile(httpServletRequest, categoryData.getCategoryThumbnail(),
					categoryData.getCategoryName(), null, null, Constants.IMG_TYPE_CATEGORY);
			categoryData.setCategoryThumbnailUrl(categoryData.getCategoryName() + ".jpg");
		}

		if (categoryServiceImpl.addCategory(categoryData))
			return "redirect:/manage/products?operation=" + Constants.CATEGORY_SAVE_SUCCESS;
		else
			return "redirect:/manage/products?operation=" + Constants.CATEGORY_SAVE_FAIL;

	}
	
	@RequestMapping(value = {Constants.URL_PRODUCT_ADD})
	public String addProduct(Model model) {
		model.addAttribute("userClickedOption", "addProduct");
		model.addAttribute("title", "Add New Product");
		model.addAttribute("menu", "manageProducts");
		ProductData productData = new ProductData();
		model.addAttribute("productData", productData);
		return "master";
	}

	private void uploadImages(ProductData productData, HttpServletRequest httpServletRequest) {
		if (productData.getProductLandscapeImage() != null
				&& !productData.getProductLandscapeImage().getOriginalFilename().isEmpty()) {
			FileUploadUtil.uploadFile(httpServletRequest, productData.getProductLandscapeImage(),
					productData.getProductCode(), productData.getProductCategoryId(), Constants.IMAGE_LANDSCAPE_SUFFIX,
					Constants.IMG_TYPE_PRODUCT);
			productData.setProductLandscapeUrl(FileUploadUtil.getLandscapeImageUrl(productData.getProductCategoryId(),
					productData.getProductCode()));
		}
		if (productData.getProductPortraitImage() != null
				&& !productData.getProductPortraitImage().getOriginalFilename().isEmpty()) {
			FileUploadUtil.uploadFile(httpServletRequest, productData.getProductPortraitImage(),
					productData.getProductCode(), productData.getProductCategoryId(), Constants.IMAGE_PORTRAIT_SUFFIX,
					Constants.IMG_TYPE_PRODUCT);
			productData.setProductPortraitUrl(FileUploadUtil.getPortraitImageUrl(productData.getProductCategoryId(),
					productData.getProductCode()));
		}
	}
}
