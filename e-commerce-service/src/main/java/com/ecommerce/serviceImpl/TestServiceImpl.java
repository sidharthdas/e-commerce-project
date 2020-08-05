package com.ecommerce.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.dto.PriceWithDiscountDTO;
import com.ecommerce.dto.ProductWithoutQuantityDTO;
import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.dto.UserEmailAndCartDTO;
import com.ecommerce.dto.UserNameAndProductDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;
import com.ecommerce.service.UserDetailService;

@Service("test")
public class TestServiceImpl implements UserDetailService {

	@Override
	public UserDetailInfo addUser(UserDetailDTO userDetailsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDummyUsers() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> getUserNameAndEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUserEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getDomainCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getUserCartByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllCartDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEmailAndCartDTO> getUserCart(List<String> userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUserCartDetails(long userId, long product_Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDetail> getUserDetailWithSpecificProduct(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetail> getUserDetailWithMorethantwoProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUserCartProductQuantityDetails(long userId, long productId, int productQuantity) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getUserCartValue(long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> getUserCartProductQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail removeProductFromUserCart(long userId, long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEmailAndCartDTO> getUserCartDetailWithExtraAddedProduct(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNameAndProductDTO> getUserNameWithProductNameAndPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductWithoutQuantityDTO> getProductWithinRange(float startRange, float endRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PriceWithDiscountDTO> getProductWithDiscount(float discount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object forgetPassword(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object checkOTP(String OTP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetail updateUser(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "in test";
	}

}
