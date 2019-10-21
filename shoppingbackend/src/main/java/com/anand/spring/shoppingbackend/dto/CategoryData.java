package com.anand.spring.shoppingbackend.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author A Anand
 *
 */
public class CategoryData {

	private Long categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryThumbnailUrl;
	private MultipartFile categoryThumbnail;

	public CategoryData() {
		super();
	}

	public CategoryData(Long categoryId, String categoryName, String categoryDescription, String categoryThumbnailUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryThumbnailUrl = categoryThumbnailUrl;
	}

	public MultipartFile getCategoryThumbnail() {
		return categoryThumbnail;
	}

	public void setCategoryThumbnail(MultipartFile categoryThumbnail) {
		this.categoryThumbnail = categoryThumbnail;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryThumbnailUrl() {
		return categoryThumbnailUrl;
	}

	public void setCategoryThumbnailUrl(String categoryThumbnailUrl) {
		this.categoryThumbnailUrl = categoryThumbnailUrl;
	}

	@Override
	public String toString() {
		return "CategoryHome [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryThumbnailUrl=" + categoryThumbnailUrl + "]";
	}
}
