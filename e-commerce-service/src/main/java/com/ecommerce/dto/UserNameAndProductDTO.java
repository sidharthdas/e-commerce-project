package com.ecommerce.dto;

import java.util.ArrayList;
import java.util.Collection;

public class UserNameAndProductDTO {
	
	private String email;
	private Collection<ProductWithoutQuantityDTO> productWithoutQuantity = new ArrayList<>();
	
	public UserNameAndProductDTO() {
		
	}
	
	
	
	



	public Collection<ProductWithoutQuantityDTO> getProductWithoutQuantity() {
		return productWithoutQuantity;
	}







	public void setProductWithoutQuantity(Collection<ProductWithoutQuantityDTO> productWithoutQuantity) {
		this.productWithoutQuantity = productWithoutQuantity;
	}







	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
    
	
}
