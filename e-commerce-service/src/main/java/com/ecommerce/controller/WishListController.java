package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.WishList;
import com.ecommerce.service.WishListService;

@RestController
@RequestMapping("/api/wishList")
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	
	@PostMapping("/add-product-to-wishList/{userId}")
	public WishList addProductToWishList(@RequestBody List<String> product, @PathVariable("userId") Long userId){
		return wishListService.addProductToWishList(product, userId);
	}
	
	@PostMapping("/test")
	public void addtest() {
		wishListService.addTest();
		System.out.println("test i 2 3 . . ");
	}

}
