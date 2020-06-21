package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Audited()
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String prodName;
	private float price;
	private int productQuantity;
	
	
	public Product() {
		
	}
	
	@JsonBackReference
	@ManyToMany(mappedBy = "products")
	private Collection<Cart> carts = new ArrayList<>();
	
	
	
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

}
