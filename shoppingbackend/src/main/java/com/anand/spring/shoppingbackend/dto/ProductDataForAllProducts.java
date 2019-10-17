package com.anand.spring.shoppingbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Product DTO for All Products Page
 * 
 * @author A Anand
 *
 */
public class ProductDataForAllProducts {

	private String productCode;
	private String productName;
	@JsonIgnore
	private String productDescription;
	private Double productUnitCost;
	private Integer productQuantity;
	private Integer productOverallRating;
	private String productThumbnailUrl;

	public ProductDataForAllProducts() {
		super();
	}

	public ProductDataForAllProducts(String productCode, String productName, String productDescription,
			Double productUnitCost, Integer productQuantity, Integer productOverallRating, String productThumbnailUrl) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productUnitCost = productUnitCost;
		this.productQuantity = productQuantity;
		this.productOverallRating = productOverallRating;
		this.productThumbnailUrl = productThumbnailUrl;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductUnitCost() {
		return productUnitCost;
	}

	public void setProductUnitCost(Double productUnitCost) {
		this.productUnitCost = productUnitCost;
	}

	public Integer getProductOverallRating() {
		return productOverallRating;
	}

	public void setProductOverallRating(Integer productOverallRating) {
		this.productOverallRating = productOverallRating;
	}

	public String getProductThumbnailUrl() {
		return productThumbnailUrl;
	}

	public void setProductThumbnailUrl(String productThumbnailUrl) {
		this.productThumbnailUrl = productThumbnailUrl;
	}

	@Override
	public String toString() {
		return "ProductDataForAllProducts [productCode=" + productCode + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", productUnitCost=" + productUnitCost
				+ ", productOverallRating=" + productOverallRating + ", productThumbnailUrl=" + productThumbnailUrl
				+ "]";
	}

}
