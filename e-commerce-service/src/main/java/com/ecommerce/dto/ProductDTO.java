package com.ecommerce.dto;

public class ProductDTO {

	private String prodName;
	private float price;
	private int productQuantity;
	
	public ProductDTO() {
		
	}
	
	

	public ProductDTO(String prodName, float price, int productQuantity) {
		this.prodName = prodName;
		this.price = price;
		this.productQuantity = productQuantity;
	}



	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
