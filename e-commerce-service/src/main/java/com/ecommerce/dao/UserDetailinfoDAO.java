package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.UserDetailInfo;

@Repository
@Transactional
public interface UserDetailinfoDAO extends CrudRepository<UserDetailInfo, Long> {
	
	@Query(value = "SELECT * FROM UserDetailInfo", nativeQuery = true)
	List<UserDetailInfo> getAllUser();
}
