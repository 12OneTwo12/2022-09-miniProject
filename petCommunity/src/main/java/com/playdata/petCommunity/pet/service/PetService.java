package com.playdata.petCommunity.pet.service;

import com.playdata.petCommunity.command.PetVO;

public interface PetService {
	
	public PetVO petJoin(PetVO petVO, String userId); //가입
	
}
