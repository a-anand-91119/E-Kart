package com.anand.spring.onlineshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.shoppingbackend.daoimpl.CategoryDAOImpl;
import com.anand.spring.shoppingbackend.dto.Category;

/**
 * Main Controller Class For Shopping Application
 * 
 * @author A Anand
 *
 */
@Controller
public class MainController {

	@Autowired
	private CategoryDAOImpl categoryDAOImpl; // TODO change to CategoryService
	
	@RequestMapping(value = {Constants.URL_ROOT, Constants.URL_HOME, Constants.URL_INDEX})
	public String getMainPage(Model model) {
		model.addAttribute("userClickedOption", "home");
		model.addAttribute("categoryData", categoryDAOImpl.findAll());
		model.addAttribute("title", "Online Shopping");
		model.addAttribute("menu", "home");
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_ABOUT})
	public String aboutPage(Model model) {
		model.addAttribute("userClickedOption", "about");
		model.addAttribute("title", "About Us");
		model.addAttribute("menu", "about");
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_CONTACT_US})
	public String contactUsPage(Model model) {
		model.addAttribute("userClickedOption", "contact");
		model.addAttribute("title", "Contact Us");
		model.addAttribute("menu", "contact");
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_ALL_PRODUCTS})
	public String showAllProducts(Model model) {
		model.addAttribute("title", "All Products");
		model.addAttribute("userClickedOption", "allProducts");
		model.addAttribute("categoryData", categoryDAOImpl.findAll());
		model.addAttribute("menu", "allProducts");
		return "master";
	}
	
	@RequestMapping(value = {Constants.URL_CATEGORY_PRODUCTS})
	public String showProductsOfParticularCategory(Model model, @PathVariable("categoryId") Integer categoryId) {
		Category category = null;
		category = (Category) categoryDAOImpl.findById(categoryId);
		model.addAttribute("title", category.getCategoryName());
		model.addAttribute("categoryData", categoryDAOImpl.findAll());
		model.addAttribute("category", category);
		model.addAttribute("userClickedOption", "category");
		model.addAttribute("menu", category.getCategoryName());
		return "master";
	}
}
