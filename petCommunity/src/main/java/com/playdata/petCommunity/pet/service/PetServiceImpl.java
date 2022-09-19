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
		
		return petMapper.save(pet);
	}
	

}
