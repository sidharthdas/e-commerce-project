package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.WishList;

public interface WishListService {
	
	WishList addProductToWishList(List<String> productName, Long userId);
	public void addTest();

}
