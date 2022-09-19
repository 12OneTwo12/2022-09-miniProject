package com.playdata.petCommunity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.DoctorVO;
import com.playdata.petCommunity.doctor.service.DoctorService;
import com.playdata.petCommunity.entity.Doctor;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	// 의사 로그인화면
	@GetMapping("/doctorLogin")
	public String doctorLogin()	{
		return "doctor/doctorLogin";
	}
	
	
	
	// 의사 회원가입화면
	@GetMapping("/doctorJoin")
	public String doctorJoin()	{
		return "doctor/doctorJoin";
	}
	
	// 의사회원가입
	@PostMapping("/doctorJoinForm")
	public String doctorJoinForm(Doctor en, RedirectAttributes RA) {
		
		Doctor result = doctorService.doctorJoin(en);
		
		if(result != null) { //의사 회원가입성공
			RA.addFlashAttribute("msg", "가입을 축하드립니다");
			 return "redirect:/doctor/doctocJoin";
		} else { //회원가입실패
			RA.addFlashAttribute("msg", "가입을 실패했습니다. 입력 내용을 확인해주세요");
			return "redirect:/doctor/doctorJoinForm";
			// 실패하면 다시 의사회원가입페이지로 
		}
		
	}
	
	// 의사로그인
	@PostMapping("/doctorLogin")
	public String doctorLogin(DoctorVO vo, RedirectAttributes RA, HttpSession session) {
		
		// 의사로그인처리
		Doctor doctor = doctorService.doctorLogin(vo);
		
		if(doctor != null) { //의사 로그인 성공
			
			session.setAttribute("doctorId", doctor.getDoctorId());
			session.setAttribute("doctorName", doctor.getDoctorName());
			
			return "redirect:/main"; // 성공 시 메인하면으로 이동
		} else { // 의사 로그인 실패
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "redirect:/doctor/doctorLogin";
		}
	}
	
	// 의사 회원정보 수정
	@PostMapping("/doctorUpdate")
	public String doctorUpdate(DoctorVO vo) {
		
		doctorService.doctorUpdate(vo);
		
		return "doctor/doctorUpdate";
	}
	
	// 의사 탈퇴
	@GetMapping("/doctorDelete")
	public void doctorDelete(Doctor en) {
		doctorService.doctorDelete(en);
	}
	
	
}
