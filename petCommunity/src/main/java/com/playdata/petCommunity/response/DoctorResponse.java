package com.playdata.petCommunity.response;

import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.entity.Doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorResponse {

	public DoctorVO updateDoctorVOByEntity(Doctor doctor) {
		return new DoctorVO(
							doctor.getDoctorName(),
							doctor.getDoctorLicenseNumber(),
							doctor.getDoctorPhoneNumber(),
							doctor.getDoctorId(),
							doctor.getDoctorPw(),
							doctor.getDoctorLocation(),
							doctor.getDoctorRecommend(),
							doctor.getDoctorState()
							);
				
	}
}
