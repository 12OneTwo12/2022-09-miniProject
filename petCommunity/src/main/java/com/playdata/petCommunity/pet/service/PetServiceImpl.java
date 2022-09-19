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
	public Pet petJoin(Pet pet) {
		
		String petNumber = pet.getPetBirth()+"-";
		
		if(pet.getPetGender().equals("수컷")) {
			petNumber += "7";
		} else if (pet.getPetGender().equals("암컷")) {
			petNumber += "8";
		} else if (pet.getPetGender().equals("중성")) {
			petNumber += "9";
		}
		
		
		
		return petMapper.save(pet);
	}
	

}
