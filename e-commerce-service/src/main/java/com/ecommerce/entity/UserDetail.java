package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited()
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long userId;

	private String userName;

	private String password;
	
	@OneToOne
	private Cart cart;
	
	@OneToOne
	private WishList wishList;

	@Version
	private long version;

	public UserDetail() {

	}
	
	

	public WishList getWishList() {
		return wishList;
	}



	public void setWishList(WishList wishList) {
		this.wishList = wishList;
	}



	public UserDetail(Long userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;

	}

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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
