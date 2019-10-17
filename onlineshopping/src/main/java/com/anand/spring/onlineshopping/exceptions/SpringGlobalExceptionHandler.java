package com.anand.spring.onlineshopping.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.anand.spring.onlineshopping.configuration.SpringLogger;
import com.anand.spring.shoppingbackend.exceptions.InvalidCategoryIdException;
import com.anand.spring.shoppingbackend.exceptions.InvalidProductCodeException;

/**
 * Global Exception Handler Class. All Exceptions are Handled here and proper error page is displayed.
 * 
 * @author A Anand
 *
 */
@ControllerAdvice
public class SpringGlobalExceptionHandler {

	@Autowired
	private SpringLogger springLogger;
	
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public String noHandlerFoundExceptionHandler(Model model, NoHandlerFoundException e) {
		springLogger.getLogger().error("No Handler Mapping Found", e);
		model.addAttribute("errorTitle", "Oops, you broke the internet");
		model.addAttribute("errorMessage",
				"Just kidding. But it seems Robo, your personal robot, " + "can't find the page you're looking for. "
						+ "Please make sure you've entered the correct address, "
						+ "or return to <a href=\"/onlineshopping\">home</a>.");
		return "error";
	}

	@ExceptionHandler(value = InvalidCategoryIdException.class)
	public String invalidExceptionHandler(Model model, InvalidCategoryIdException e) {
		springLogger.getLogger().error("Invalid Category Id Provided", e);
		model.addAttribute("errorTitle", "Oops, Invalid Category ID Provided");
		model.addAttribute("errorMessage",
				"It seems Robo, your personal robot, " + "can't find the category you were looking for. "
						+ "Please make sure you've entered the correct Category ID, "
						+ "or return to <a href=\"/onlineshopping\">home</a>.");
		return "error";
	}

	@ExceptionHandler(value = NumberFormatException.class)
	public String numberFormatExceptionHandler(Model model, NumberFormatException e) {
		springLogger.getLogger().error("Invalid Integer Provided", e);
		model.addAttribute("errorTitle", "Oops, Invalid Number Provided");
		model.addAttribute("errorMessage",
				"It seems Robo, your personal robot, " + "couldn't parse the entered number. "
						+ "Please make sure you've entered a valid Number, "
						+ "or return to <a href=\"/onlineshopping\">home</a>.");
		return "error";
	}

	@ExceptionHandler(value = InvalidProductCodeException.class)
	public String invalidProductCodeExceptionHandler(Model model, InvalidProductCodeException e) {
		springLogger.getLogger().error("Invalid Product Code Entered", e);
		model.addAttribute("errorTitle", "Oops, Invalid Product Code");
		model.addAttribute("errorMessage",
				"It seems Robo, your personal robot, " + "can't find the Product you were looking for. "
						+ "Please make sure you've entered the correct Product Code, "
						+ "or return to <a href=\"/onlineshopping\">home</a>.");
		return "error";
	}

	@ExceptionHandler(value = Exception.class)
	public String generalExceptionHandler(Model model, Exception e) {
		springLogger.getLogger().error("Unknown Exception Occured", e);
		model.addAttribute("errorTitle", "Oops, Unknown Error Occured");
		model.addAttribute("errorMessage",
				"It seems Robo, your personal robot, " + "encountered an error while displaying an error  :p  "
						+ "Return to <a href=\"/onlineshopping\">home</a>.");
		return "error";
	}
}
