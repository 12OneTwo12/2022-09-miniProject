package com.playdata.petCommunity.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLoginVO {

	private String doctorId;
	private String doctorPw;
}
