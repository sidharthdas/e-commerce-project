package com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.UserDetailDAO;
import com.ecommerce.dao.WishListDAO;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.WishList;
import com.ecommerce.service.WishListService;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDetailDAO userDetailDAO;
	
	@Autowired
	private WishListDAO wishListDAO;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public WishList addProductToWishList(List<String> productName, Long userId) {
		
		
		// TODO Auto-generated method stub
		List<Product> allProduct = productDAO.getallProduct();
		
		
		
		for(String p : productName) {
			Product product = productDAO.getProductByName(p).get(0);
			
			
			if(allProduct.contains(p)) {
				UserDetail user = userDetailDAO.getUserById(userId).get(0);
				if(user.getWishList().getProducts().contains(p)) {
					
				}
				else {
					WishList wishList = new WishList();
					List<Product> prod = new ArrayList<>();
					prod.add(product);
					wishList.setProducts(prod);
					user.setWishList(wishList);
					userDetailDAO.save(user);
					
				}
			}
		}
		return userDetailDAO.getUserById(userId).get(0).getWishList();
	}
	@Transactional
	@Override
	public void addTest() {
		
		wishListDAO.test();
		System.out.println("in add test emthod");
		
		Integer.parseInt("");
		
		
		
		
	}



	

}
