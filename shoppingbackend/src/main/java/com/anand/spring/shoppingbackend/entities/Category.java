package com.anand.spring.shoppingbackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Category Entity Class
 * 
 * @author A Anand
 *
 */
@Entity
public class Category {
	
	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(name = "c_name")
	private String categoryName;
	
	@Column(name = "c_description")
	private String categoryDescription;
	
	@Column(name = "c_thumbnail_url")
	private String categoryThumbnailURL;
	
	@Column(name = "c_is_active")
	private Boolean categoryIsActive = true;

	public Category() {
		super();
	}

	public Category(Long categoryId, String categoryName, String categoryDescription, String categoryThumbnailURL,
			Boolean categoryIsActive) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryThumbnailURL = categoryThumbnailURL;
		this.categoryIsActive = categoryIsActive;
	}

	public Boolean getCategoryIsActive() {
		return categoryIsActive;
	}

	public void setCategoryIsActive(Boolean categoryIsActive) {
		this.categoryIsActive = categoryIsActive;
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

	public String getCategoryThumbnailURL() {
		return categoryThumbnailURL;
	}

	public void setCategoryThumbnailURL(String categoryThumbnailURL) {
		this.categoryThumbnailURL = categoryThumbnailURL;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryThumbnailURL=" + categoryThumbnailURL + ", categoryIsActive="
				+ categoryIsActive + "]";
	}

}
