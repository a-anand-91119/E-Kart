package com.anand.spring.shoppingbackend.dto;

/**
 * Cateory Data to be displayed in the sidebar
 * 
 * @author A Anand
 *
 */
public class CategorySideBarData {

	private Long categoryId;
	private String categoryName;

	public CategorySideBarData() {
		super();
	}

	public CategorySideBarData(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
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

	@Override
	public String toString() {
		return "CategorySideBarData [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
