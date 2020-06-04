package com.ecommerce.dto;

import com.ecommerce.entity.Cart;

public class UserEmailAndCartDTO {
	
	private String userName;
	private Cart cart;
	
	
	public UserEmailAndCartDTO() {
		
	}
	
	public UserEmailAndCartDTO(String userName, Cart cart) {
		super();
		this.userName = userName;
		this.cart = cart;
	}




	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
