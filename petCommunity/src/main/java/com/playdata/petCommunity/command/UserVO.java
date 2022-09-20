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
public class UserVO {

//	private Long uno;
	
	private String userName;
	
	private String userPhoneNumber;
	
	private String userId;
	
	private String userPw;
	
	private String userLocation;
	
}
