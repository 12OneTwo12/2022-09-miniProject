package com.playdata.petCommunity.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(String userId) {
		return userRepository.findByUserId(userId);
	}
//
//	@Override
//	public User userIdCheck(UserVO vo) {
//		return userRepository.findByUser_id(vo.getUserId());
//	}

//	@Override
//	public int userJoin(UserVO vo) {
//		return userRepository.userJoin(vo);
//	}
//
//	@Override
//	public UserVO userLogin(UserVO vo) {
//		return userRepository.userLogin(vo);
//	}

//	@Override
//	public int idCheck(UserVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	

}
