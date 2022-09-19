package com.playdata.petCommunity.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.QUser;
import com.playdata.petCommunity.entity.User;
import com.querydsl.core.BooleanBuilder;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
<<<<<<< HEAD
	@Override
	public User getUser(String userId) {
		return userRepository.findByUserId(userId);
	}
//
//	@Override
//	public User userIdCheck(UserVO vo) {
//		return userRepository.findByUser_id(vo.getUserId());
//	}
=======
	@Autowired
	UserRepository userRepository;
>>>>>>> a5b24f97ecba632b2fdb670a2b1f210f5fde7a93

	@Override
	public User userIdCheck(UserVO vo) {
		return userRepository.findByUserId(vo.getUserId());
	}

	@Override
	public User userJoin(User en) {
	
		if(userRepository.findByUserId(en.getUserId()) != null) {
			return null;
		} else {
			return userRepository.save(en);
		}
	}

	@Override
	public User userLogin(UserVO vo) {

		QUser qUser = QUser.user;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qUser.userState.contains("정상 등록"));
		
		builder.and(qUser.userId.contains(vo.getUserId()));
		
		builder.and(qUser.userPw.contains(vo.getUserPw()));
		
		return userRepository.findAll(builder).iterator().next();
	}

	@Override
	public User userUpdate(User user) {
		return userRepository.save(user);
	}

	@Override
	public User userDelete(String userId) {
		
		User user = userRepository.findByUserId(userId);
		
		user.setUserState("탈퇴");
		
		return userRepository.save(user);
	}



}
