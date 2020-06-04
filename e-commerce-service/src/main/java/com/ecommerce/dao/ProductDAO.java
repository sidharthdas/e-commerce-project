package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query(value = "SELECT COUNT(*) FROM PRODUCT WHERE PRODUCTID = :productId", nativeQuery = true)
	int countProductById(@Param("productId")long productId);
	
	@Modifying
	@Query(value = "UPDATE PRODUCT SET PRODUCTQUANTITY = :productQuantity WHERE productID = :productID", nativeQuery = true)
	int updateProductQuantityByProductId(@Param("productQuantity")int productQuantity, @Param("productID")long productID );
	
	@Query(value = "SELECT PRODUCTQUANTITY FROM PRODUCT WHERE PRODUCTID = :productId", nativeQuery = true)
	List<Integer> quantityOfProductById(@Param("productId")long productId);
	
	@Query(value = "SELECT PRICE FROM PRODUCT WHERE PRODUCTID = :productId", nativeQuery = true)
	float getProductPricebyId(@Param("productId")long productId);
	
	@Query(value = "SELECT PRODUCTID FROM PRODUCT", nativeQuery = true)
	List<Product> getListOfProductId();
	
	@Query(value = "SELECT * FROM PRODUCT", nativeQuery = true)
	List<Product> getallProduct();

}
