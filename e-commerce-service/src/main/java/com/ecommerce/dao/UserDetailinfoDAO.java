package com.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.entity.UserDetailInfo;

@Repository
@Transactional
public interface UserDetailinfoDAO extends CrudRepository<UserDetailInfo, Long> {

}
