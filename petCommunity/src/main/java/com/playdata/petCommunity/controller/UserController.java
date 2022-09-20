package com.playdata.petCommunity.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.UserLoginVO;
import com.playdata.petCommunity.command.UserVO;
import com.playdata.petCommunity.entity.Doctor;
import com.playdata.petCommunity.entity.User;
import com.playdata.petCommunity.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService;
	
	//유저 로그인화면
	@GetMapping("/userLogin")
	public String userLogin() {
		return "user/user_login";
	}
	
	// 유저 회원가입화면
	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/user_signin";
	}
	
//	@GetMapping({"/user_login","user_signin","main"})
//	public void view() {
//		
//	} 이거 내일 가서 말해야함 return 하는곳에 _ 말고 -이걸로 바꿔야함 convention
	
	// 유저회원가입
	//회원가입 성공하면 바로 반려동물 정보입력페이지로
	@PostMapping("/userJoinForm")
	public String userJoinForm(@RequestBody UserVO vo, RedirectAttributes RA) {
		
		User result = userService.userJoin(vo);
		
		if(result != null) { // 유저회원가입성공
			RA.addFlashAttribute("msg", "가입을 축하드립니다");
			return "redirect:/pet/petJoin"; //나중에 수정
		} else { //회원가입실패
			RA.addFlashAttribute("msg", "가입에 실패했습니다. 입력 내용을 확인해주세요");
			return "redirect:/user/userJoinForm";
			// 실패하면 다시 회원가입페이지로 가는 return
		}
		
	}
	
	// 유저로그인
	@PostMapping("/userLogin")
	public String userLogin(@RequestBody UserLoginVO vo, RedirectAttributes RA, HttpSession session) {
		
		// 유저로그인처리
		User user = userService.userLogin(vo);
		if(user !=null ) { //유저 로그인 성공
			
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
			
			return "redirect:/main"; //성공 시 메인화면으로 이동
		} else { // 유저 로그인 실패
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "redirect:/user/userLogin";
		}
		
	}
	
	// 유저 회원정보 수정
	@PostMapping("/userUpdateForm")
	public String userUpdateForm(@RequestBody UserVO vo, RedirectAttributes RA) {
			
		 User check = userService.userUpdate(vo);
			
		if(check == null) {
			RA.addFlashAttribute("msg", "정보 변경도중 문제가 발생했습니다 관리자에게 문의해주세요");
			return "redirect:/user/userUpdate";
		} else {
			RA.addFlashAttribute("msg", "정상적으로 변경 됐습니다");
			return "redirect:/user/userJoin";
		}
			
	}
	
	// 유저 탈퇴
	@GetMapping("/userDeleteForm")
	public String userDeleteForm(HttpSession session, RedirectAttributes RA) {
		
		String userId = (String) session.getAttribute("userId");
		
		User user = userService.userDelete(userId);
		
		if(user == null) {
			RA.addFlashAttribute("msg", "탈퇴 도중 문제가 발생했습니다 관리자에게 문의해주세요");
			return "redirect:/user/userUpdate";
		} else if(user.getUserState().equals("탈퇴")) {
			RA.addFlashAttribute("msg", "탈퇴 완료 됐습니다");
			session.invalidate();
			
			return "reidrect:/main"; // 홈페이지로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "탈퇴 도중 문제가 발생했습니다 관리자에게 문의해주세요");
			return "redirect:/user/userUpdate";
		}
		
	}
	
}
	
