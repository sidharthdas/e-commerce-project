package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Audited
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	
	public Cart() {
		
	}
	
	public Cart(int cartId) {

		this.cartId = cartId;
	}
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Product> products = new ArrayList<>();

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

}
