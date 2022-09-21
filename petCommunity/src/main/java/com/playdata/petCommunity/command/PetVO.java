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
public class PetVO {

	private Long pno;
	
	private String petName;
	
	private String petBirth;
	
	private String petNumber;
	
	private String petWeight;
	
	private String petCategory;
	
	private Long uno;
	
}
