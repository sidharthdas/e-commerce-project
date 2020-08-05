package com.ecommerce.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.WishList;

@Repository
@Transactional
public interface WishListDAO extends CrudRepository<WishList, Long>{
	
	@Modifying
	@Query(value = "UPDATE Product set price = 900000 where productId = 1", nativeQuery = true)
	void test();

}
