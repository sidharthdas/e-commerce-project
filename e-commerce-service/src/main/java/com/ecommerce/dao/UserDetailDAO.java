package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.UserDetail;
import com.ecommerce.entity.UserDetailInfo;



@Repository
@Transactional
public interface UserDetailDAO extends CrudRepository<UserDetail, Long>{
	//Anjali
	@Query(value = "SELECT COUNT(*) FROM UserDetail where userName = :email ", nativeQuery = true)
	int userCount(@Param("email")String email);
	
	@Query(value = "SELECT USERNAME FROM UserDetail", nativeQuery = true)
	List<String> allUserNames();
	
	@Query(value = "select * from userdetail where userId = :id ", nativeQuery = true)
	List<UserDetail> getUserById(@Param("id")long id);
	
    @Query(value="select * from UserDetail", nativeQuery = true)
    List<UserDetail> allUserDetail();
	
   
}
