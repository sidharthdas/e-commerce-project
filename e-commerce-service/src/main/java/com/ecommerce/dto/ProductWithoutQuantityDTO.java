package com.ecommerce.dto;

public class ProductWithoutQuantityDTO {

	private String prodName;
	private float price;
	
	public ProductWithoutQuantityDTO() {
		
	}
	
	public ProductWithoutQuantityDTO(String prodName, float price) {
		super();
		this.prodName = prodName;
		this.price = price;
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
