package com.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	@Autowired
	private UserDetailinfoDAO userDetailInfoDAO;

	@Override
	public UserDetailInfo addUser(UserDetailDTO userDetailDTO) {
		// TODO Auto-generated method stub
		if (Objects.isNull(userDetailDTO)) {
			return null;
		}

		if (userDetailDAO.userCount(userDetailDTO.getEmail()) == 0) {
			Cart cart = new Cart();
			cartDAO.save(cart);
			UserDetail userDetail = new UserDetail();
			userDetail.setCart(cart);
			userDetail.setPassword(userDetailDTO.getPassword());
			userDetail.setUserName(userDetailDTO.getEmail());

			userDetailDAO.save(userDetail);

			UserDetailInfo userDetailInfo = new UserDetailInfo();
			userDetailInfo.setEmail(userDetailDTO.getEmail());
			userDetailInfo.setName(userDetailDTO.getName());
			userDetailInfo.setPhoneNum(userDetailDTO.getPhoneNum());

			return userDetailinfoDAO.save(userDetailInfo);
		}
		return null;
	}

	@Override
	public List<String> getAllName() {
		// TODO Auto-generated method stub
		return userDetailDAO.allUserNames();
	}

	@Override
	public void addDummyUsers() {
	
	List<UserDetailDTO> dummyUsers = new ArrayList<>();	
	dummyUsers.add(new UserDetailDTO("Sidharth", "sidharthdas.1995@gmail.com", 70084, "test@123"));
	dummyUsers.add(new UserDetailDTO("Sagar", "sagardas.195@hotmail.com", 989898, "test@123"));
	dummyUsers.add(new UserDetailDTO("Anjali", "anjalidawadi@yahoo.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Ram", "ram@gmail.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Sita", "sita@gmail.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Gita", "gita@gmail.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Dev", "dev@hotmail.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Koustav", "koustav@yahoo.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Ajay", "ajay@outook.com", 567890, "test@123"));
	dummyUsers.add(new UserDetailDTO("Amlan", "amlan@outlook.com", 567890, "test@123"));
	
	dummyUsers.forEach(user ->{
		addUser(user);
	});
	
		

	}

	@Override
	public Map<String, String> getUserNameAndEmail() {
		// TODO Auto-generated method stub
		Map<String,String> userNamesAndEmail = new HashMap<>();
		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();
		
		allUser.forEach(user->{
			userNamesAndEmail.put(user.getEmail(), user.getName());
		});
		return userNamesAndEmail;
	}

	@Override
	public List<String> getUserEmail() {
		List<String> userEmail1 = new ArrayList<String>();
		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();
		
		
		allUser.forEach(user->{
				userEmail1.add(user.getEmail());
			});
		
		List<String> userEmail2 = new ArrayList<String>();
		for (String element : userEmail1){
	         if (element.contains("gmail")){
	              userEmail2.add(element);
	         }
	   
		}
		 return userEmail2;
	}

	@Override
	public Map<String, Integer> getDomainCount() {
		
		Map<String, Integer> domainCount = new HashMap<>();
		
		List<UserDetailInfo> allUser = userDetailInfoDAO.getAllUser();
		
		allUser.forEach(user->{
			
			String[] email = user.getEmail().split("@");
			String[] domain = email[1].split("\\.");
			String domainName = domain[0];
			
			if(domainCount.containsKey(domainName)) {
				domainCount.put(domainName, domainCount.get(domainName)+1);
				
			}else {
				domainCount.put(domainName, 1);
			}
		});
		return domainCount;
	}

}
