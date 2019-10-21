package com.anand.spring.onlineshopping.configuration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

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
	
	/**
	 * maxFileSize: Maximum Size of the file to be uploaded
	 * maxRequestSize: Maximum Size of the multipart/form-data request
	 * fileSizeThreshold: Size threshold after which the file will be written to disk
	 * 
	 * The Size are in bytes
	 * 1024  * 1024  *  1 = 1MB
	 * 1024  * 1024  *  2 = 2MB
	 * 1024  * 1024  *  4 = 4MB
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/", 2097152, 8388608, 1048576);
		registration.setMultipartConfig(multipartConfigElement);
	}
	
	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(
				servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
}
