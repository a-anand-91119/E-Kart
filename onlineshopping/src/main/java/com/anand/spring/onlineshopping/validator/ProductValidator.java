package com.anand.spring.onlineshopping.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.anand.spring.shoppingbackend.dto.ProductData;

/**
 * Custom Validator to validate the Landscape and Portrait Images of Products
 * 
 * @author A Anand
 *
 */
@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductData productData = (ProductData) target;

		if (productData.getProductLandscapeImage() == null
				|| productData.getProductLandscapeImage().getOriginalFilename().equals("")) {
			errors.rejectValue("productLandscapeImage", null, "Please Select A Landscape Image");
		} else if (!
				(productData.getProductLandscapeImage().getContentType().equals("image/jpg")
				|| productData.getProductLandscapeImage().getContentType().equals("image/png")
				|| productData.getProductLandscapeImage().getContentType().equals("image/jpeg"))) {
				errors.rejectValue("productLandscapeImage", null, "Only PNG, JPG and JPEG Formats are supported for Landscape Image");
		}

		if (productData.getProductPortraitImage() == null
				|| productData.getProductPortraitImage().getOriginalFilename().equals("")) {
			errors.rejectValue("productPortraitImage", null, "Please Select A Portrait Image");
		}else if (!
				(productData.getProductPortraitImage().getContentType().equals("image/jpg")
				|| productData.getProductPortraitImage().getContentType().equals("image/png")
				|| productData.getProductPortraitImage().getContentType().equals("image/jpeg"))) {
				errors.rejectValue("productPortraitImage", null, "Only PNG, JPG and JPEG Formats are supported for Portrait Image");
		}

	}

}
