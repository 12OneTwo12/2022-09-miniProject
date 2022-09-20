package com.playdata.petCommunity.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.PetVO;
import com.playdata.petCommunity.entity.Pet;
import com.playdata.petCommunity.repository.PetRepository;

@Service("petService")
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetRepository petMapper;

	@Override
	public PetVO petJoin(PetVO petVO, String userId) {
		
		String petNumber = petVO.getPetBirth()+"-";
		
		if(petVO.getPetGender().equals("수컷")) {
			petNumber += "7";
		} else if (petVO.getPetGender().equals("암컷")) {
			petNumber += "8";
		} else if (petVO.getPetGender().equals("중성")) {
			petNumber += "9";
		}
		
		return null;
	}
	

}
