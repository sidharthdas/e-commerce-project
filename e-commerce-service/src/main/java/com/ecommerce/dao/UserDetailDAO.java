package com.ecommerce.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.UserDetail;



@Repository
@Transactional
public interface UserDetailDAO extends CrudRepository<UserDetail, Long>{
	
	@Query(value = "SELECT COUNT(*) FROM UserDetail where userName = :email ", nativeQuery = true)
	int userCount(@Param("email")String email);

}
