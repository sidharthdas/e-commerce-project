package com.ecommerce.dto;

public class ProductIDAndProductQuantityDTO {
   
	private long productId;
	private int productQuantity;
	
	public ProductIDAndProductQuantityDTO() {
		
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
}
