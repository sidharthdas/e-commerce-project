package com.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.entity.UserDetailInfo;

public interface UserDetailService {
	
	UserDetailInfo addUser(UserDetailDTO userDetailsDTO);
	List<String> getAllName();
	void addDummyUsers();
	Map<String, String> getUserNameAndEmail();
}
