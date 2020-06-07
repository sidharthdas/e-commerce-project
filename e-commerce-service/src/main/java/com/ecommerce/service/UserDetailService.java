package com.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.dto.PriceWithDiscountDTO;
import com.ecommerce.dto.ProductWithoutQuantityDTO;
import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.dto.UserEmailAndCartDTO;
import com.ecommerce.dto.UserNameAndProductDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;

public interface UserDetailService {
	
	UserDetailInfo addUser(UserDetailDTO userDetailsDTO);
	List<String> getAllName();
	void addDummyUsers();
	Map<String, String> getUserNameAndEmail();
	List<String> getUserEmail();
	Map<String,Integer> getDomainCount();
	Cart getUserCartByID(long id);
	List<Cart> getAllCartDetail();
	List<UserEmailAndCartDTO> getUserCart(List<String> userName);
	void getUserCartDetails(long userId,long product_Id);
	List<UserDetail> getUserDetailWithSpecificProduct(String productName);
	List<UserDetail> getUserDetailWithMorethantwoProduct();
	void getUserCartProductQuantityDetails(long userId,long productId,int productQuantity);
	float getUserCartValue(long userId);
	Map<String,Integer> getUserCartProductQuantity();
	UserDetail removeProductFromUserCart(long userId,long productId);
	List<UserEmailAndCartDTO> getUserCartDetailWithExtraAddedProduct (long productId);
	List<UserNameAndProductDTO> getUserNameWithProductNameAndPrice();
	List<ProductWithoutQuantityDTO> getProductWithinRange(float startRange, float endRange);
	List<PriceWithDiscountDTO> getProductWithDiscount(float discount);
	Object forgetPassword(String userEmail);
	Object checkOTP(String OTP);
}
