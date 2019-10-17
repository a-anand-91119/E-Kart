package com.anand.spring.onlineshopping.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.anand.spring.onlineshopping.utils.Constants;
import com.anand.spring.shoppingbackend.configuration.SpringRootConfiguration;

/**
 * The Web Application Servlet Initializer
 * 
 * @author A Anand
 *
 */
public class OnlineShoppingDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringRootConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringWebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {Constants.URL_ROOT};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}
	
	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(
				servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
}
