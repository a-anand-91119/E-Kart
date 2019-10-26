package com.anand.spring.onlineshopping.utils;

public class Constants {

	public static final String URL_ROOT = "/";
	public static final String URL_INDEX = "/index";
	public static final String URL_HOME = "/home";
	public static final String URL_ABOUT = "/about";
	public static final String URL_CONTACT_US = "/contactUs";
	public static final String URL_ALL_PRODUCTS = "/allProducts";
	public static final String URL_CATEGORY_PRODUCTS = "/category/{categoryId}/products";
	public static final String URL_SHOW_PRODUCT = "/show/product/{productCode}";
	public static final String URL_MANAGEMENT = "/manage";
	public static final String URL_JSON_DATA = "/json/data";
	public static final String URL_MANAGE_PRODUCT = "/products";
	public static final String URL_SAVE_PRODUCT = "/products/save";
	public static final String URL_ADMIN_MANAGE_PRODUCTS = "/admin/manage/products";
	// for json
	public static final String URL_MANAGE_PRODUCTS = "/manage/products";
	
	public static final String WEB_RESOURCE_PREFIX = "/WEB-INF/view/";
	public static final String WEB_RESOURCE_SUFFIX = ".jsp";
	public static final String PRODUCT_SAVE_SUCCESS = "SSP";
	public static final String PRODUCT_UPDATE_SUCCESS = "SUP";
	public static final char IMG_TYPE_PRODUCT = 'P';
	public static final char IMG_TYPE_CATEGORY = 'C';
	public static final String CATEGORY_SAVE_SUCCESS = "CS";
	public static final String CATEGORY_SAVE_FAIL = "CF";
	
	public static final String IMAGE_PORTRAIT_SUFFIX = "_port";
	public static final String IMAGE_LANDSCAPE_SUFFIX = "_land";
	public static final String URL_PRODUCT_STATUS_CHANGE = "/products/{productCode}/activation";
	public static final String URL_EDIT_PRODUCT = "/product/{productCode}/edit";
	public static final String URL_SAVE_UPDATE_PRODUCT = "/product/{productCode}/save";
	public static final String URL_ADD_CATEGORY = "/category/add";
	public static final String URL_PRODUCT_ADD = "/products/add";
	
	public static final String ROLE_USER = "USER";
	public static final String ROLE_SUPPLIER = "SUPPLIER";


}
