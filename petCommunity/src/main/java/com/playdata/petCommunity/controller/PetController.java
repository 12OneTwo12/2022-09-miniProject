package com.playdata.petCommunity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.PetVO;
import com.playdata.petCommunity.pet.service.PetService;


@Controller
@RequestMapping("/pet")
public class PetController {


	@Autowired
	private PetService petService;
  
  @RequestMapping("pet_signup")
  public String pet_signup() {
	  return"pet/pet_signup";
  }
	
	// 반려동물정보 입력화면으로 이동
	@GetMapping("/petJoin")
	public String join() {
		return "pet/petJoinForm";
	}
	
	// 반려동물정보 입력화면
	@PostMapping("/petJoinForm")
	public String petJoinForm(PetVO vo, RedirectAttributes RA) {
		
		int result = petService.petJoin(vo);
		
		if(result == 1) { //반려동물 정보입력성공
			RA.addFlashAttribute("msg", "반려동물의 정보가 입력되었습니다");
		}
		return "redirect:/main";
		
	}
	


}
