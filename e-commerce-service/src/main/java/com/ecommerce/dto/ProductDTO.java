package com.ecommerce.dto;

public class ProductDTO {

	private long productId;
	private String prodName;
	private float price;
	private int productQuantity;
	private String productBrand;
	private String productColor;

	public ProductDTO() {

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public ProductDTO(String prodName, float price, int productQuantity, String productBrand, String productColor) {
		this.prodName = prodName;
		this.price = price;
		this.productQuantity = productQuantity;
		this.productBrand = productBrand;
		this.productColor = productColor;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
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
