package com.playdata.petCommunity.doctor.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>,
										  QuerydslPredicateExecutor<Doctor> {
	// 아이디 중복체크 -이 메소드 컨트롤러 회원가입에서 써야하는데 어디 들어가야하는지 헷갈림
	Doctor findByDoctorId(String doctorId);

//	// 의사 로그인
//	@Query(value="select * from doctor where id= ? and where pw= ? ",
//			nativeQuery=true)
//	Doctor doctorLogin(DoctorVO vo);
//	
//	// 의사 정보 수정
//	@Modifying
//	@Query(value="update doctor set doctor_location = ?, doctor_name=?, doctor_pw=? where doctor_id=?",
//		   nativeQuery=true)
//	Doctor doctorUpdate(DoctorVO vo);
//	
//	// 의사 탈퇴 - 
//	Doctor doctorDelete(Doctor en);
	

}
