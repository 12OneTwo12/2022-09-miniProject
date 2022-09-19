package com.playdata.petCommunity.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.entity.Doctor;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor doctorIdCheck(DoctorVO vo) {
		return doctorRepository.findByDoctor_id(vo.getDoctorId());
	}

	@Override // 의사 회원가입
	public Doctor doctorJoin(Doctor en) {
		
		if(doctorRepository.findByDoctor_id(en.getDoctorId()) != null ) {
			return null; // 회원가입시 아이디 중복체크해서 null값이 아니라면 null을 반환해서 controller에서 회원가입실패 메시지가 뜨게
			
		} else {
			return doctorRepository.save(en);
		}
		
	}

	@Override
	public Doctor doctorLogin(DoctorVO vo) {
		return doctorRepository.doctorLogin(vo);
	}
	
	@Override
	public Doctor doctorUpdate(DoctorVO vo) {
		return doctorRepository.doctorUpdate(vo);
	}

	@Override
	public void doctorDelete(Doctor en) {
//		en.setDoctorState
		doctorRepository.save(en);
	}
	
}
