package com.playdata.petCommunity.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.PetVO;

@Service("petService")
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetMapper petMapper;

	@Override
	public int petJoin(PetVO vo) {
		
		return petMapper.petJoin(vo);
	}
	

}
