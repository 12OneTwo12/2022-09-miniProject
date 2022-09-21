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
import com.playdata.petCommunity.response.UserResponse;
import com.playdata.petCommunity.util.page.Encrypt;
import com.querydsl.core.BooleanBuilder;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserVO getUser(String userId) {
		return new UserResponse().updateUserVOByEntity(userRepository.findByUserId(userId));
	}

	
	@Override
	public UserVO userIdCheck(UserVO vo) {
		return new UserResponse().updateUserVOByEntity(userRepository.findByUserId(vo.getUserId()));
	}

	@Override
	public UserVO userJoin(UserVO vo) {
	
		if(userRepository.findByUserId(vo.getUserId()) != null) {
			return null;
		} else {

			String hashPw = Encrypt.getEncrypt(vo.getUserPw(), vo.getUserId());
			
			vo.setUserPw(pwHash);
			vo.setUserState("정상 등록"); // 일단 이렇게
			return new UserResponse().updateUserVOByEntity(userRepository.save(convertUserVOtoUser(vo)));
		}
	}
	
	@Override
	public UserVO userLogin(UserLoginVO vo) {

		String hashPw = Encrypt.getEncrypt(vo.getUserPw(), vo.getUserId());
		
		QUser qUser = QUser.user;
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qUser.userState.contains("정상 등록"));
		
		builder.and(qUser.userId.contains(vo.getUserId()));
		builder.and(qUser.userPw.contains(hashPw));
		
		return new UserResponse().updateUserVOByEntity(userRepository.findAll(builder).iterator().next());
	}

	@Override
	public UserVO userUpdate(UserVO vo) {
		User user = userRepository.findByUserId(vo.getUserId());
		
		String hashPw = Encrypt.getEncrypt(vo.getUserPw(), user.getUserId());
		
		if(hashPw.equals(user.getUserPw())) {
			vo.setUserNewPw(Encrypt.getEncrypt(vo.getUserNewPw, user.getUserId()));
			User result = user.updateUserByVO(vo);
			return new UserResponse().updateUserVOByEntity(userRepository.save(result));
		} else {
			return null;
		}
		
	}
	
	@Override
	public UserVO userDelete(String userId) {
		
		User user = userRepository.findByUserIdWithoutDelete(userId);
		
		user.setUserState("탈퇴");
		
		return new UserResponse().updateUserVOByEntity(userRepository.save(user));
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
				vo.getUserState()
				);

	}
	

}
