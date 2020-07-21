package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.dto.SearchForm;
import com.ecommerce.entity.Product;

public interface ProductService {
	
	void addDummyProduct();
	ProductDTO addProduct(ProductDTO product);
	List<ProductDTO> addListOfProduct(List<ProductDTO> products);
	List<Product> searchProduct(SearchForm searchForm);

}
