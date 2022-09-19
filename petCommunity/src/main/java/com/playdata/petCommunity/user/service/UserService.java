package com.playdata.petCommunity.user.service;

import com.playdata.petCommunity.entity.User;

public interface UserService {
	
	public User getUser(String userId);
	
//	public int idCheck(UserVO vo); //중복체크
//	public int userJoin(UserVO vo); // 유저회원가입
//	public UserVO userLogin(UserVO vo); // 유저로그인
//	User userIdCheck(UserVO vo);

}
