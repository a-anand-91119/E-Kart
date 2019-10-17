package com.anand.spring.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anand.spring.onlineshopping.configuration.SpringLogger;
import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.shoppingbackend.dto.CategoryHome;
import com.anand.spring.shoppingbackend.dto.ProductData;
import com.anand.spring.shoppingbackend.exceptions.InvalidCategoryIdException;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;
import com.anand.spring.shoppingbackend.services.CategoryService;
import com.anand.spring.shoppingbackend.services.ProductService;

/**
 * Main Controller Class For Shopping Application
 * 
 * @author A Anand
 *
 */
@Controller
public class MainController {

	@Autowired
	private SpringLogger springLogger;
	@Autowired
	private CategoryService categoryServiceImpl;
	@Autowired
	private ProductService productServiceImpl;
	
	@RequestMapping(value = {Constants.URL_ROOT, Constants.URL_HOME, Constants.URL_INDEX})
	public String getMainPage(Model model) {
		model.addAttribute("userClickedOption", "home");
		model.addAttribute("categoryData", categoryServiceImpl.getCategoryPreview());
		model.addAttribute("title", "Online Shopping");
		model.addAttribute("menu", "home");
		springLogger.getLogger().info("Inside MainController Root Method");	
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_ABOUT})
	public String aboutPage(Model model) {
		model.addAttribute("userClickedOption", "about");
		model.addAttribute("title", "About Us");
		model.addAttribute("menu", "about");
		springLogger.getLogger().info("Inside MainController About Method");	
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_CONTACT_US})
	public String contactUsPage(Model model) {
		model.addAttribute("userClickedOption", "contact");
		model.addAttribute("title", "Contact Us");
		model.addAttribute("menu", "contact");
		springLogger.getLogger().info("Inside MainController Contact Us Method");	
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_ALL_PRODUCTS})
	public String showAllProducts(Model model) {
		model.addAttribute("title", "All Products");
		model.addAttribute("userClickedOption", "allProducts");
		model.addAttribute("categorySidebarData", categoryServiceImpl.getSideBarCategories());
		model.addAttribute("productData", productServiceImpl.getAllActiveProducts());
		model.addAttribute("topProducts", productServiceImpl.getHighestRatedProductWallpapers());
		model.addAttribute("menu", "allProducts");
		springLogger.getLogger().info("Inside MainController All Products Method");	
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_CATEGORY_PRODUCTS})
	public String showProductsOfParticularCategory(Model model, @PathVariable("categoryId") Long categoryId) throws InvalidCategoryIdException {
		CategoryHome category = (CategoryHome) categoryServiceImpl.findCategoryById(categoryId);
		model.addAttribute("title", category.getCategoryName());
		model.addAttribute("productData", productServiceImpl.getAllActiveProductsByCategory(category.getCategoryId()));
		model.addAttribute("categorySidebarData", categoryServiceImpl.getSideBarCategories());
		model.addAttribute("category", category);
		model.addAttribute("topProducts", productServiceImpl.getHighestRatedProductWallpapers());
		model.addAttribute("userClickedOption", "category");
		model.addAttribute("menu", category.getCategoryName());
		springLogger.getLogger().info("Inside MainController Category Method");	
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_SHOW_PRODUCT})
	public String showProduct(Model model, @PathVariable(name = "productCode") String productCode) throws InvalidCategoryIdException, InvalidProductCodeException {
		ProductData product = productServiceImpl.getProduct(productCode);
		model.addAttribute("title", product.getProductName());
		model.addAttribute("productInformation", product);
		model.addAttribute("userClickedOption", "product");
		model.addAttribute("categorySidebarData", categoryServiceImpl.getSideBarCategories());
		CategoryHome category = (CategoryHome) categoryServiceImpl.findCategoryById(product.getProductCategoryId());
		model.addAttribute("menu", category.getCategoryName());
		model.addAttribute("category", category);
		springLogger.getLogger().info("Inside MainController Single Method");	
		return "master";
	}
}
