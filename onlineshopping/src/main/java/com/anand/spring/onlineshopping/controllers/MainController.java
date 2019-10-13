package com.anand.spring.onlineshopping.controllers;

import org.springframework.stereotype.Controller;
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
	public String root() {
		return "index";
	}
}
