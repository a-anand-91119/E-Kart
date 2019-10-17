package com.anand.spring.shoppingbackend.dto;

/**
 * 
 * @author A Anand
 *
 */
public class ProductData {

	private Long productId;
	private String productCode;
	private String productName;
	private String productBrand;
	private String productDescription;
	private Double productUnitPrice;
	private Long productCategoryId;
	private Integer productPurchases;
	private Integer productQuantity;
	private Integer productViews;
	private Integer productRating1;
	private Integer productRating2;
	private Integer productRating3;
	private Integer productRating4;
	private Integer productRating5;
	private String productPortraitUrl;
	private String productLandscapeUrl;
	private Integer productOverallrating;

	public ProductData() {
		super();
	}

	public ProductData(Long productId, String productCode, String productName, String productBrand,
			String productDescription, Double productUnitPrice, Long productCategoryId, Integer productPurchases,
			Integer productQuantity, Integer productViews, Integer productRating1, Integer productRating2,
			Integer productRating3, Integer productRating4, Integer productRating5, String productPortraitUrl,
			String productLandscapeUrl, Integer productOverallrating) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.productUnitPrice = productUnitPrice;
		this.productCategoryId = productCategoryId;
		this.productPurchases = productPurchases;
		this.productQuantity = productQuantity;
		this.productViews = productViews;
		this.productRating1 = productRating1;
		this.productRating2 = productRating2;
		this.productRating3 = productRating3;
		this.productRating4 = productRating4;
		this.productRating5 = productRating5;
		this.productPortraitUrl = productPortraitUrl;
		this.productLandscapeUrl = productLandscapeUrl;
		this.productOverallrating = productOverallrating;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(Double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Integer getProductPurchases() {
		return productPurchases;
	}

	public void setProductPurchases(Integer productPurchases) {
		this.productPurchases = productPurchases;
	}

	public Integer getProductViews() {
		return productViews;
	}

	public void setProductViews(Integer productViews) {
		this.productViews = productViews;
	}

	public Integer getProductRating1() {
		return productRating1;
	}

	public void setProductRating1(Integer productRating1) {
		this.productRating1 = productRating1;
	}

	public Integer getProductRating2() {
		return productRating2;
	}

	public void setProductRating2(Integer productRating2) {
		this.productRating2 = productRating2;
	}

	public Integer getProductRating3() {
		return productRating3;
	}

	public void setProductRating3(Integer productRating3) {
		this.productRating3 = productRating3;
	}

	public Integer getProductRating4() {
		return productRating4;
	}

	public void setProductRating4(Integer productRating4) {
		this.productRating4 = productRating4;
	}

	public Integer getProductRating5() {
		return productRating5;
	}

	public void setProductRating5(Integer productRating5) {
		this.productRating5 = productRating5;
	}

	public String getProductPortraitUrl() {
		return productPortraitUrl;
	}

	public void setProductPortraitUrl(String productPortraitUrl) {
		this.productPortraitUrl = productPortraitUrl;
	}

	public String getProductLandscapeUrl() {
		return productLandscapeUrl;
	}

	public void setProductLandscapeUrl(String productLandscapeUrl) {
		this.productLandscapeUrl = productLandscapeUrl;
	}

	public Integer getProductOverallrating() {
		return productOverallrating;
	}

	public void setProductOverallrating(Integer productOverallrating) {
		this.productOverallrating = productOverallrating;
	}

	@Override
	public String toString() {
		return "ProductData [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", productBrand=" + productBrand + ", productDescription=" + productDescription
				+ ", productUnitPrice=" + productUnitPrice + ", productCategoryId=" + productCategoryId
				+ ", productPurchases=" + productPurchases + ", productViews=" + productViews + ", productRating1="
				+ productRating1 + ", productRating2=" + productRating2 + ", productRating3=" + productRating3
				+ ", productRating4=" + productRating4 + ", productRating5=" + productRating5 + ", productPortraitUrl="
				+ productPortraitUrl + ", productLandscapeUrl=" + productLandscapeUrl + ", productOverallrating="
				+ productOverallrating + "]";
	}

}
