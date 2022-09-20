package com.playdata.petCommunity.user.service;

import com.playdata.petCommunity.command.UserLoginVO;
import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.User;

public interface UserService {
	
	public User getUser(String userId);
	
	User userIdCheck(UserVO vo); // 유저 아이디 중복체크
	
	User userJoin(UserVO vo); //유저 회원가입
	
	User userLogin(UserLoginVO vo); //유저 로그인
	
	User userUpdate(UserVO vo); // 유저 정보 수정
	
	User userDelete(String doctorId); // 유저 탈퇴

}
