package com.ecommerce.dto;

import java.util.ArrayList;
import java.util.Collection;
import com.ecommerce.entity.Product;

public class UserCartDetailDTO {
     
	private Long userId;
	private Collection<Product> products = new ArrayList<>();
	
	public UserCartDetailDTO() {
		
	}

	public UserCartDetailDTO(Long userId, Collection<Product> products) {
		super();
		this.userId = userId;
		this.products = products;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	
}
