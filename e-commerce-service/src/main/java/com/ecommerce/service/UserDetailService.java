package com.ecommerce.service;

import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.entity.UserDetailInfo;

public interface UserDetailService {
	
	UserDetailInfo addUser(UserDetailDTO userDetailsDTO);

}
