package com.playdata.petCommunity.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.playdata.petCommunity.entity.User;

public interface UserRepository extends JpaRepository<User, Long>,
										QuerydslPredicateExecutor<User>{
	
	// 아이디 중복체크
	User findByUser_id(String userId);

}
