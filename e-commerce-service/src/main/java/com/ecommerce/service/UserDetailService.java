package com.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.dto.UserEmailAndCartDTO;
import com.ecommerce.entity.Cart;
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
}
