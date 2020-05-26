package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDTO;

public interface ProductService {
	
	void addDummyProduct();
	ProductDTO addProduct(ProductDTO product);
	List<ProductDTO> addListOfProduct(List<ProductDTO> products);

}
