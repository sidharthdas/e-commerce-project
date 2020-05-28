package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.Product;

@Repository
@Transactional
public interface ProductDAO extends CrudRepository<Product, Long>{
	
	@Query(value = "SELECT COUNT(*) FROM PRODUCT WHERE PRODNAME = :productName", nativeQuery = true)
	int countProduct(@Param("productName")String productName);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE productId = :productId", nativeQuery = true)
	List<Product> getProductById(@Param("productId")long productId);

}
