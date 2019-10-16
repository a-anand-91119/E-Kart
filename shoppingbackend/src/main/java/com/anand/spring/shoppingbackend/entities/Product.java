package com.anand.spring.shoppingbackend.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * 
 * @author A Anand
 *
 */
@Entity
public class Product {

	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "p_code")
	private String productCode;

	@Column(name = "p_name")
	private String productName;
	
	@Column(name = "p_specs")
	private String productSpecs;

	@Column(name = "p_brand")
	private String productBrand;

	@Column(name = "p_description")
	private String productDescription;

	@Column(name = "p_unit_price")
	private Double productUnitPrice;

	@Column(name = "p_quantity")
	private Integer productQuantity;

	@Column(name = "p_is_active")
	private Boolean productIsActive;

	@Column(name = "p_category_id")
	private Long productCategoryId;

	@Column(name = "p_supplier_id")
	private Long productSupplierId;

	@Column(name = "p_purchases")
	private Integer productPurchases;

	@Column(name = "p_views")
	private Integer productViews;

	@Column(name = "p_rating1")
	private Integer productRating1;

	@Column(name = "p_rating2")
	private Integer productRating2;

	@Column(name = "p_rating3")
	private Integer productRating3;

	@Column(name = "p_rating4")
	private Integer productRating4;

	@Column(name = "p_rating5")
	private Integer productRating5;

	@Column(name = "p_portrait_url")
	private String productPortraitUrl;

	@Column(name = "p_wallpaper_url")
	private String productLandscapeUrl;

	@Transient
	private Integer productOverallrating;

	public Product() {
		this.productCode = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
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

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Boolean getProductIsActive() {
		return productIsActive;
	}

	public void setProductIsActive(Boolean productIsActive) {
		this.productIsActive = productIsActive;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(Long productSupplierId) {
		this.productSupplierId = productSupplierId;
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

	public Integer getProductOverallrating() {
		return productOverallrating;
	}

	public void setProductOverallrating(Integer productOverallrating) {
		this.productOverallrating = productOverallrating;
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

	public String getProductSpecs() {
		return productSpecs;
	}

	public void setProductSpecs(String productSpecs) {
		this.productSpecs = productSpecs;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", productSpecs=" + productSpecs + ", productBrand=" + productBrand + ", productDescription="
				+ productDescription + ", productUnitPrice=" + productUnitPrice + ", productQuantity=" + productQuantity
				+ ", productIsActive=" + productIsActive + ", productCategoryId=" + productCategoryId
				+ ", productSupplierId=" + productSupplierId + ", productPurchases=" + productPurchases
				+ ", productViews=" + productViews + ", productRating1=" + productRating1 + ", productRating2="
				+ productRating2 + ", productRating3=" + productRating3 + ", productRating4=" + productRating4
				+ ", productRating5=" + productRating5 + ", productPortraitUrl=" + productPortraitUrl
				+ ", productLandscapeUrl=" + productLandscapeUrl + ", productOverallrating=" + productOverallrating
				+ "]";
	}

}
