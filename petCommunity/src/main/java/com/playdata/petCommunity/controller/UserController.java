package com.playdata.petCommunity.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService;
	
	//유저 로그인화면
	@GetMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	
	// 유저 회원가입화면
	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	@GetMapping({"/user_login","user_signin","main"})
	public void view() {
		
	}
	
	// 유저회원가입
	//회원가입 성공하면 바로 반려동물 정보입력페이지로
	@PostMapping("/userJoinForm")
	public String userJoinForm(UserVO vo, RedirectAttributes RA) {
		
//		int result = userService.userJoin(vo);
//		
//		if(result == 1) { //회원가입성공
//			RA.addFlashAttribute("msg", "가입을 축하드립니다");
//			return "redirect:/pet/petJoin"; //펫 정보입력 화면으로 이동
//		} else { //회원가입실패
//			RA.addFlashAttribute("msg", "가입에 실패했습니다. 입력 내용을 확인해주세요");
//			return "redirect:/user/userJoinForm";
//			// 실패하면 다시 회원가입페이지로 가는 return
//		}
		return "";
		
	}
	
	// 유저로그인
	@PostMapping("/userLogin")
	public String userLogin(UserVO vo, RedirectAttributes RA, HttpSession session) {
		
		// 유저로그인처리
		// UserVO userVO = userService.userLogin(vo);
//		if(userVO !=null ) { //유저 로그인 성공
//			
//			session.setAttribute("userId", userVO.getUserId());
//			session.setAttribute("userName", userVO.getUserName());
//			
//			return "redirect:/main"; //성공 시 메인화면으로 이동
//		} else { // 유저 로그인 실패
//			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
//			return "redirect:/user/userLogin";
//		}
		return "";
	}
	
}
	
