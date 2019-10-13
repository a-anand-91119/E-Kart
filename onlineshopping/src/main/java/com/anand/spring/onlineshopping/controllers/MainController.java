package com.anand.spring.onlineshopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anand.spring.onlineshopping.utils.Constants;

/**
 * 
 * @author A Anand
 *
 */
@Controller
public class MainController {

	@RequestMapping(value = {Constants.URL_ROOT, Constants.URL_HOME, Constants.URL_INDEX})
	public String getMainPage(Model model) {
		model.addAttribute("userClickedOption", "home");
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
}
