package com.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class WishListDTO {

	private Long id;

	private List<ProductDTO> products = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
