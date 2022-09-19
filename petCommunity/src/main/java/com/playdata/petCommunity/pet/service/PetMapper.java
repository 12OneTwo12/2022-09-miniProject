package com.playdata.petCommunity.pet.service;

import org.apache.ibatis.annotations.Mapper;

import com.playdata.petCommunity.command.PetVO;

@Mapper
public interface PetMapper {
	
	public int petJoin(PetVO vo); // 펫 정보입력

}
