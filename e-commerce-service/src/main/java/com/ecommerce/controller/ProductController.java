package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.SearchForm;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("add-dummy-products")
	public void addDummyProduct() {
		productService.addDummyProduct();
	}
	
	@PostMapping("search-products-with-filters")
	public List<Product> searchProduct(@RequestBody SearchForm searchForm){
		return productService.searchProduct(searchForm);
	}

}
