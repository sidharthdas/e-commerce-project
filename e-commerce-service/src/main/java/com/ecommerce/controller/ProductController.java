package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.SearchForm;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product/")
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
	
	@PostMapping("sort-product-by-price")
	public List<Product> sortProductByPrice	(@RequestBody int order){
		return productService.sortProductByPrice(order);
	}
	
	@GetMapping("sort-product-by-quantity")
	public List<Product> sortProductByQuantity(){
		return productService.sortProductByQuantity();
	}
	
	public int add(int i, int j) {
		return i+j;
	}
	
	public double computeCircleArea(double radious) {
		return Math.PI * radious * radious;
	}
	
	public int multiply(int i, int j) {
		return i*j;
	}
	
	public int div(int i, int j) {
		return i/j;
	}

}
