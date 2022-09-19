package com.playdata.petCommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.playdata.petCommunity.entity.User;

public interface UserRepository extends JpaRepository<User, Long>,
										QuerydslPredicateExecutor<User>{
	
	// 아이디 중복체크
	User findByUserId(String userId);

}
