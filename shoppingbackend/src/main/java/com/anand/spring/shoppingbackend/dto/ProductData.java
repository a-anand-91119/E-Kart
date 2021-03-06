package com.anand.spring.shoppingbackend.dto;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author A Anand
 *
 */
public class ProductData {

	private Long productId;
	private Long productSupplierId;
	private String productCode;

	@NotBlank(message = "Product Name Is Mandatory")
	@Length(max = 100, message = "Maximum of 100 Characters Allowed For Product Name")
	private String productName;

	@NotBlank(message = "Product Brand Name Is Mandatory")
	@Length(max = 50, message = "Maximum of 50 Characters Allowed For Product Brand Name")
	private String productBrand;

	@Length(max = 2000, message = "Maximum of 2000 Characters Allowed For Product Specs")
	private String productSpecification;

	@NotBlank(message = "Product Description Is Mandatory")
	private String productDescription;

	@NotNull(message = "Product Unit Price Is Mandatory")
	@Min(value = 1, message = "Minimum Price Of Product is 1 Rupee")
	private Double productUnitPrice;

	@NotNull(message = "All Products Must Be Attached To A Category")
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

	private MultipartFile productLandscapeImage;
	private MultipartFile productPortraitImage;

	public ProductData() {
		this.productCode = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public ProductData(Long productId, String productCode, String productName, String productBrand,
			String productSpecification, String productDescription, Double productUnitPrice, Long productCategoryId,
			Integer productPurchases, Integer productQuantity, Integer productViews, Integer productRating1,
			Integer productRating2, Integer productRating3, Integer productRating4, Integer productRating5,
			String productPortraitUrl, String productLandscapeUrl, Integer productOverallrating) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productSpecification = productSpecification;
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

	public MultipartFile getProductLandscapeImage() {
		return productLandscapeImage;
	}

	public void setProductLandscapeImage(MultipartFile productLandscapeImage) {
		this.productLandscapeImage = productLandscapeImage;
	}

	public MultipartFile getProductPortraitImage() {
		return productPortraitImage;
	}

	public void setProductPortraitImage(MultipartFile productPortraitImage) {
		this.productPortraitImage = productPortraitImage;
	}

	public Long getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Long productSupplierId) {
		this.productSupplierId = productSupplierId;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
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
