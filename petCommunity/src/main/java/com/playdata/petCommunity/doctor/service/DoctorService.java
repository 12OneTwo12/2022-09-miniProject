package com.playdata.petCommunity.doctor.service;

import com.playdata.petCommunity.command.DoctorLoginVO;
import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.entity.Doctor;

public interface DoctorService {
	
//	public int idCheck(DoctorVO vo); // 중복체크
//	public int doctorJoin(DoctorVO vo); // 의사회원가입
//	public DoctorVO doctorLogin(DoctorVO vo); //의사 로그인
	
	Doctor doctorIdCheck(DoctorVO vo); // 의사 아이디 중복체크
	
	Doctor doctorJoin(DoctorVO vo); //의사 회원가입
	
	Doctor doctorLogin(DoctorLoginVO vo); //의사 로그인
	
	Doctor doctorUpdate(DoctorVO vo); // 의사 정보 수정
	
	Doctor doctorDelete(String doctorId); // 의사 탈퇴
	
}
