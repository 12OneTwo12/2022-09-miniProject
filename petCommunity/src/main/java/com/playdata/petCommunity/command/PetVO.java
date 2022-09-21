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
	
	@NotEmpty(message = "반려동물의 몸무게는 필수 값입니다, Kg 단위를 제외한 숫자만 적어주세요")
	private String petWeight;
	
	private String petCategory;
	
	private Long uno;
	
}
