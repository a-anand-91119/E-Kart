package com.anand.spring.onlineshopping.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	private static final Logger MY_LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);

	public static void uploadFile(HttpServletRequest httpServletRequest, MultipartFile productImage, String productCode,
			Long productCategoryId, String imageNameSuffix, char imageType) {

		if (imageType == Constants.IMG_TYPE_CATEGORY)
			uploadFile(httpServletRequest, productImage, productCode,
					"/resources/images/categories/");
		else if (imageType == Constants.IMG_TYPE_PRODUCT)
			uploadFile(httpServletRequest, productImage, productCode, productCategoryId, imageNameSuffix,
					"/resources/images");
	}

	private static void uploadFile(HttpServletRequest httpServletRequest, MultipartFile productImage,
			String categoryName, String realPathToUse) {
		MY_LOGGER.info("Uploading Image [" + productImage.getOriginalFilename() + "] for Category [" + categoryName
				+ "]");
		
		String realPath = httpServletRequest.getSession().getServletContext().getRealPath(realPathToUse);
		MY_LOGGER.info("Real Path: " + realPath);
		
		if (!new File(realPath).exists()) {
			new File(realPath).mkdirs();
		}

		try {
			productImage.transferTo(new File(realPath + categoryName + ".jpg"));

		} catch (IllegalStateException | IOException e) {
			MY_LOGGER.error("Error Occured While Uploading File. Error- " + e);
		}
	}

	private static void uploadFile(HttpServletRequest httpServletRequest, MultipartFile productImage,
			String productCode, Long productCategoryId, String imageNameSuffix, String realPathToUse) {

		MY_LOGGER.info("Uploading Image [" + productImage.getOriginalFilename() + "] for Product [" + productCode
				+ "] belonging to " + "category [" + productCategoryId + "]");

		String realPath = httpServletRequest.getSession().getServletContext().getRealPath(realPathToUse);
		realPath += "\\" + productCategoryId + "\\";
		MY_LOGGER.info("Real Path: " + realPath);

		if (!new File(realPath).exists()) {
			new File(realPath).mkdirs();
		}

		try {
			productImage.transferTo(new File(realPath + productCode + imageNameSuffix + ".jpg"));
		} catch (IllegalStateException | IOException e) {
			MY_LOGGER.error("Error Occured While Uploading File. Error- " + e);
		}
	}

	public static String getLandscapeImageUrl(Long productCategoryId, String productCode) {
		return getFileName(productCategoryId, productCode, Constants.IMAGE_LANDSCAPE_SUFFIX);
	}

	public static String getPortraitImageUrl(Long productCategoryId, String productCode) {
		return getFileName(productCategoryId, productCode, Constants.IMAGE_PORTRAIT_SUFFIX);
	}

	private static String getFileName(Long productCategoryId, String productCode, String suffix) {
		return productCategoryId + File.separator + productCode + suffix + ".jpg";
	}
}
