package com.ecommerce.serviceImpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.UserDetailDAO;
import com.ecommerce.dao.UserDetailinfoDAO;
import com.ecommerce.dto.UserDetailDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;
import com.ecommerce.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDAO userDetailDAO;

	@Autowired
	private UserDetailinfoDAO userDetailinfoDAO;

	@Autowired
	private CartDAO cartDAO;

	@Override
	public UserDetailInfo addUser(UserDetailDTO userDetailDTO) {
		// TODO Auto-generated method stub
		if (Objects.isNull(userDetailDTO)) {
			return null;
		}

		if (userDetailDAO.userCount(userDetailDTO.getEmail()) == 0) {
			Cart cart = new Cart();
			cartDAO.save(cart);
			userDetailDAO.save(new UserDetail(1l, userDetailDTO.getEmail(), userDetailDTO.getPassword()));
			return userDetailinfoDAO.save(new UserDetailInfo(1l, userDetailDTO.getName(), userDetailDTO.getEmail(),
					userDetailDTO.getPhoneNum()));
		}
		return null;
	}

}
