package com.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.UserDetailDTO;
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

}
