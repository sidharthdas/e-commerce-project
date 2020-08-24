package com.ecommerce.dto;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.WishList;

public class UserDetail1DTO {

	private Long userId;

	private String userName;

	private String password;

	private CartDTO cartDTO;

	private WishListDTO wishListDTO;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CartDTO getCartDTO() {
		return cartDTO;
	}

	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}

	public WishListDTO getWishListDTO() {
		return wishListDTO;
	}

	public void setWishListDTO(WishListDTO wishListDTO) {
		this.wishListDTO = wishListDTO;
	}

	

}
