package com.playdata.petCommunity.doctor.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.playdata.petCommunity.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>,
										  QuerydslPredicateExecutor<Doctor> {
	// 아이디 중복체크 -이 메소드 컨트롤러 회원가입에서 써야하는데 어디 들어가야하는지 헷갈림
	Doctor findByDoctorId(String doctorId);

}
