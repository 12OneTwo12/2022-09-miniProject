package com.playdata.petCommunity.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.DoctorLoginVO;
import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.Doctor;
import com.playdata.petCommunity.entity.QDoctor;
import com.playdata.petCommunity.entity.User;
import com.playdata.petCommunity.repository.DoctorRepository;
import com.querydsl.core.BooleanBuilder;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor doctorIdCheck(DoctorVO vo) {
		return doctorRepository.findByDoctorId(vo.getDoctorId());
	}

	@Override // 의사 회원가입
	public Doctor doctorJoin(DoctorVO vo) {
		
		if(doctorRepository.findByDoctorId(vo.getDoctorId()) != null ) {
			return null; // 회원가입시 아이디 중복체크해서 null값이 아니라면 null을 반환해서 controller에서 회원가입실패 메시지가 뜨게
		} else {
			return doctorRepository.save(convertDoctorVOtoDoctor(vo));
		}
		
	}

	@Override
	public Doctor doctorLogin(DoctorLoginVO vo) {
		
		QDoctor qDoctor = QDoctor.doctor;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qDoctor.doctorState.contains("정상 등록"));
		
		builder.and(qDoctor.doctorId.contains(vo.getDoctorId()));
		
		builder.and(qDoctor.doctorPw.contains(vo.getDoctorPw()));
		
		return doctorRepository.findAll(builder).iterator().next();
	}
	
	@Override
	public Doctor doctorUpdate(DoctorVO vo) {
		Doctor doctor = doctorRepository.findByDoctorId(vo.getDoctorId());
		
		return doctor.updateDoctorByVO(vo);
	}

	@Override
	public Doctor doctorDelete(String doctorId) {

		Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		
		doctor.setDoctorState("탈퇴");
		
		return doctor;
	}
	
	private Doctor convertDoctorVOtoDoctor(DoctorVO vo) {
		return new Doctor(null, 
				vo.getDoctorName(),
				vo.getDoctorLicenseNumber(),
				vo.getDoctorPhoneNumber(), 
				vo.getDoctorId(), 
				vo.getDoctorPw(),
				vo.getDoctorLocation(),
				null,
				null);
	}
}
