package com.playdata.petCommunity.user.service;

import com.playdata.petCommunity.command.UserVO;

public interface UserService {
	
	public int idCheck(UserVO vo); //중복체크
	public int userJoin(UserVO vo); // 유저회원가입
	public UserVO userLogin(UserVO vo); // 유저로그인

}
