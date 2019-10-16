package com.anand.spring.shoppingbackend.dto;

/**
 * 
 * @author A Anand
 *
 */
public class ProductWallpapersData {

	private String productImageUrl;
	private Long productCategory;
	private String productCode;
	private String productName;

	public ProductWallpapersData() {
		super();
	}

	public ProductWallpapersData(String productImageUrl, Long productCategory, String productCode, String productName) {
		super();
		this.productImageUrl = productImageUrl;
		this.productCategory = productCategory;
		this.productCode = productCode;
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Long getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Long productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "ProductWallpapersData [productImageUrl=" + productImageUrl + ", productCategory=" + productCategory
				+ ", productCode=" + productCode + ", productName=" + productName + "]";
	}

}
