package com.playdata.petCommunity.user.service;

<<<<<<< HEAD
=======
import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.Doctor;
>>>>>>> a5b24f97ecba632b2fdb670a2b1f210f5fde7a93
import com.playdata.petCommunity.entity.User;

public interface UserService {
	
	public User getUser(String userId);
	
//	public int idCheck(UserVO vo); //중복체크
//	public int userJoin(UserVO vo); // 유저회원가입
//	public UserVO userLogin(UserVO vo); // 유저로그인
//	User userIdCheck(UserVO vo);
	
	User userIdCheck(UserVO vo); // 유저 아이디 중복체크
	
	User userJoin(User en); //유저 회원가입
	
	User userLogin(UserVO vo); //유저 로그인
	
	User userUpdate(User user); // 유저 정보 수정
	
	User userDelete(String doctorId); // 유저 탈퇴

}
