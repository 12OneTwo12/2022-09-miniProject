package com.playdata.petCommunity.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.PetVO;
import com.playdata.petCommunity.entity.Pet;
import com.playdata.petCommunity.pet.service.PetService;
import com.playdata.petCommunity.user.service.UserService;


@Controller
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;
	
	@Autowired
	private UserService userService;
  
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
	public String petJoinForm(Pet pet, HttpSession session , RedirectAttributes RA) {
		
		String userId = (String) session.getAttribute("userId");
		
		pet.setUser(userService.getUser(userId));
		
		Pet result = petService.petJoin(pet);
		
		if(result != null) { //반려동물 정보입력성공
			RA.addFlashAttribute("msg", "반려동물의 정보가 입력되었습니다");
			return "redirect:/"; // 마이 페이지
		} else {
			RA.addFlashAttribute("msg", "등록 과정에 문제가 생겼습니다 관리자에게 문의해주세요");
			return "redirect:/"; // 펫 등록 페이지 
		}
		
	}
	
}
