package com.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.UserDetail;

public interface UserDetailDAO extends CrudRepository<UserDetail, Long>{

}
