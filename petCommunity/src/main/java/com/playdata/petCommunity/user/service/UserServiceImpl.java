package com.playdata.petCommunity.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.petCommunity.command.UserLoginVO;
import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.QUser;
import com.playdata.petCommunity.entity.User;
import com.playdata.petCommunity.repository.UserRepository;
import com.querydsl.core.BooleanBuilder;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(String userId) {
		return userRepository.findByUserId(userId);
	}

	
	@Override
	public User userIdCheck(UserVO vo) {
		return userRepository.findByUserId(vo.getUserId());
	}

	@Override
	public User userJoin(UserVO vo) {
	
		if(userRepository.findByUserId(vo.getUserId()) != null) {
			return null;
		} else {
			return userRepository.save(convertUserVOtoUser(vo));
		}
	}
	
	@Override
	public User userLogin(UserLoginVO vo) {

		QUser qUser = QUser.user;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qUser.userState.contains("정상 등록"));
		
		builder.and(qUser.userId.contains(vo.getUserId()));
		
		builder.and(qUser.userPw.contains(vo.getUserPw()));
		
		return userRepository.findAll(builder).iterator().next();
	}

	@Override
	public User userUpdate(UserVO vo) {
		User user = userRepository.findByUserId(vo.getUserId());
		
		return user.updateUserByVO(vo);
	}
	
	@Override
	public User userDelete(String userId) {
		
		User user = userRepository.findByUserId(userId);
		
		user.setUserState("탈퇴");
		
		return user;
	}

	// save는 entity만 매개변수로 받을 수 있기 때문에
	// vo를 entity로 바꿔주는 역할
	private User convertUserVOtoUser(UserVO vo) {
		return new User(null, 
				vo.getUserName(), 
				vo.getUserPhoneNumber(), 
				vo.getUserId(), 
				vo.getUserPw(),
				vo.getUserLocation(),
				vo.getUserLocationDetail(),
				null);
	}

}
