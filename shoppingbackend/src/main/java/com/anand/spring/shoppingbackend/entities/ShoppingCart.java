package com.anand.spring.shoppingbackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author A Anand
 *
 */
@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sc_id")
	private Long cartId;

	@Column(name = "sc_user_id")
	private Long cartUser;

	@Column(name = "sc_cart_line")
	private Long cartNoOfItems;

	@Column(name = "sc_total")
	private Double cartTotal;

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Long cartId, Long cartUser, Long cartNoOfItems, Double cartTotal) {
		super();
		this.cartId = cartId;
		this.cartUser = cartUser;
		this.cartNoOfItems = cartNoOfItems;
		this.cartTotal = cartTotal;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getCartUser() {
		return cartUser;
	}

	public void setCartUser(Long cartUser) {
		this.cartUser = cartUser;
	}

	public Long getCartNoOfItems() {
		return cartNoOfItems;
	}

	public void setCartNoOfItems(Long cartNoOfItems) {
		this.cartNoOfItems = cartNoOfItems;
	}

	public Double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", cartUser=" + cartUser + ", cartNoOfItems=" + cartNoOfItems
				+ ", cartTotal=" + cartTotal + "]";
	}

}
