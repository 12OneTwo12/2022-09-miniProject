package com.playdata.petCommunity.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.playdata.petCommunity.entity.Pet;

@Mapper
public interface PetRepository extends JpaRepository<Pet, Long>, 
										QuerydslPredicateExecutor<Pet>{
	
}
