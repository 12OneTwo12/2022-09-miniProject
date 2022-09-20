package com.playdata.petCommunity.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorVO {

//	private Long dno;
	
	private String doctorName;
	
	private String doctorLicenseNumber;
	
	private String doctorPhoneNumber;
	
	private String doctorId;
	
	private String doctorPw;
	
	private String doctorLocation;
	
	private Long doctorRecommend;
	
}
