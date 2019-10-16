package com.anand.spring.shoppingbackend.dto;

public class CategoryData {
	
	private Long categoryId;
	private String categoryName;
	private String categoryDescription;
	private String categoryThumbnailUrl;

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
