package com.anand.spring.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anand.spring.onlineshopping.configuration.SpringLogger;
import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.shoppingbackend.dto.CategorySideBarData;
import com.anand.spring.shoppingbackend.dto.ProductData;
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
	private ProductService productServiceImpl;
	
	@Autowired
	private SpringLogger springLogger;

	@RequestMapping(value = { Constants.URL_MANAGE_PRODUCT }, method = RequestMethod.GET)
	public String manageProducts(Model model, @RequestParam(name = "operation", required = false) String operation) {
		model.addAttribute("userClickedOption", "manageProduct");
		model.addAttribute("title", "Manage Products");
		model.addAttribute("menu", "manageProducts");
		if (operation!= null && operation.equals(Constants.PRODUCT_SAVE_SUCCESS))
			model.addAttribute("message", "success");
		ProductData productData = new ProductData();
		model.addAttribute("productData", productData);
		return "master";
	}

	@ModelAttribute("categories")
	public List<CategorySideBarData> getAllCategories() {
		return categoryServiceImpl.getSideBarCategories();
	}

	@RequestMapping(value = { Constants.URL_SAVE_PRODUCT }, method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productData") ProductData productData, Model model) {
		productData.setProductSupplierId(new Long(2));
		springLogger.getLogger().info("Created Product: " + productData);
		productServiceImpl.createProduct(productData);
		model.addAttribute("userClickedOption", "manageProduct");
		model.addAttribute("title", "Manage Products");
		model.addAttribute("menu", "manageProducts");
		return "redirect:/" + Constants.URL_MANAGEMENT + Constants.URL_MANAGE_PRODUCT + "?operation="
				+ Constants.PRODUCT_SAVE_SUCCESS;
	}

}
