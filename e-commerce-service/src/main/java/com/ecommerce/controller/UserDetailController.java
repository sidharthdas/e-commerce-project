package com.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductIDAndProductQuantityDTO;
import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.dto.UserEmailAndCartDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;
import com.ecommerce.service.UserDetailService;

@RestController
@RequestMapping("userdetail")
public class UserDetailController {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@PostMapping("/add-user")
	public ResponseEntity<UserDetailInfo> addUser(@RequestBody UserDetailDTO userDetailDTO){
		return new ResponseEntity<UserDetailInfo>(userDetailService.addUser(userDetailDTO), HttpStatus.OK);
	}
	
	@GetMapping("/usernames")
	public ResponseEntity<List<String>> getAllNames(){
		return new ResponseEntity<List<String>>(userDetailService.getAllName(), HttpStatus.OK);
	}
	
	@PostMapping("/add-dummy-users")
	public void addDummyUsers() {
		userDetailService.addDummyUsers();
	}
	
	@GetMapping("/get-username-and-email")
	public Map<String, String> getUserNameAndEmail(){
		return userDetailService.getUserNameAndEmail();
	}
	
	@GetMapping("/get-useremail")
	public List<String> getUserEmail(){
		return userDetailService.getUserEmail();
	}
	
	@GetMapping("/get-domain-Count")
	public Map<String,Integer> getUserEmailCount(){
		return userDetailService.getDomainCount();
	}
	
	@GetMapping("get-cart-by-id/{id}")
	public Cart getUserCart(@PathVariable("id")long id) {
		return userDetailService.getUserCartByID(id);
	}

	@GetMapping("get-allCart/")
	public List<Cart> getAllCart() {
		return userDetailService.getAllCartDetail(); 
	}
	
	@PostMapping("/get-user-cart-by-userName")
	public List<UserEmailAndCartDTO> getUserCart(@RequestBody List<String> userName){
		return userDetailService.getUserCart(userName);
	}
	
	@PostMapping("/add-product-to-cart/{userId}")
	public void addProductToCart(@PathVariable("userId")long userId,@RequestBody long product_Id){
		userDetailService.getUserCartDetails(userId,product_Id);
		//return null;
	}
	
	@GetMapping("get-user-details-with-specific-product_name/{productName}")
	public List<UserDetail> getUserDetailsWithSpecificProduct(@PathVariable("productName")String productName){
		return userDetailService.getUserDetailWithSpecificProduct(productName);
	}
	
	@GetMapping("get-user-details-with-more-than-two-product/")
	public List<UserDetail> getUserDetailsWithMoreThanTwoProduct(){
		return userDetailService.getUserDetailWithMorethantwoProduct();
	}
	
	@PostMapping("add-user-product-quantity-to-cart-/{userId}")
	public void addProductQuantityToCart(@PathVariable("userId")long userId,@RequestBody ProductIDAndProductQuantityDTO productIdAndProductQuantityDTO){
		userDetailService.getUserCartProductQuantityDetails(userId, productIdAndProductQuantityDTO.getProductId(), productIdAndProductQuantityDTO.getProductQuantity());
		//return null;
	}
	
	@GetMapping("get-user-cart-product-value/{userId}")
	public float getUserCArtProductValue(@PathVariable("userId")long userId) {
		return userDetailService.getUserCartValue(userId);
	}
	
	@GetMapping("get-user-cart-product-quantity/")
	public Map<String,Integer> getUserCartProductQuantity(){
		return userDetailService.getUserCartProductQuantity();
	}
	
	@DeleteMapping("delete-product-from-cart/{userId}")
	public UserDetail deleteproductfromcart(@PathVariable("userId")long userId,@RequestBody long productId) {
		return userDetailService.removeProductFromUserCart(userId, productId);
	}
}
