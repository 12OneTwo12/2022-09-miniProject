package com.playdata.petCommunity.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.CommentVO;
import com.playdata.petCommunity.command.NoticeVO;
import com.playdata.petCommunity.comment.service.CommentService;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.notice.service.NoticeService;
import com.playdata.petCommunity.util.page.Criteria;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	NoticeService noticeService;
	
	@Autowired
	@Qualifier("commentService")
	CommentService commentService;
	
	@RequestMapping("/noticeListAll")
	public String noticeListAll(Criteria cri, Model model) {
		
		List<NoticeVO> list = noticeService.getList(cri);
		
		model.addAttribute("list", list);
		
		return ""; // 전체 목록 조회 페이지
	}
	
	@RequestMapping("/noticeMyList")
	public String noticeMyList(Criteria cri, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return ""; // 작성자 id 값 없음으로 홈페이지로 리다이렉트
		} else {
			String userId = (String) session.getAttribute("userId");
			cri.setWriter(userId);
			List<NoticeVO> list = noticeService.getListByWriter(cri);
			
			model.addAttribute("list", list);
			
			return ""; // user 자기 글 조회 목록 페이지
		}
		
	}
	
	@RequestMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("nno") Long nno, Model model, RedirectAttributes RA) {
		
		NoticeVO noticeVO = noticeService.getDetailById(nno);
		
		if(noticeVO == null) {
			
			RA.addFlashAttribute("msg", "잘못된 조회 방법입니다");
			
			return ""; // nno 값으로 조회했을 때 없는 글, 홈페이지로 리다이렉트
		} else if(noticeVO.getNoticeState().equals("삭제")){
			
			RA.addFlashAttribute("msg", "삭제된 게시글 입니다");
			
			return ""; // 삭제된 글이라고 메세지 뛰운 후 홈페이지로 리다이렉트
		} else {
			
			List<CommentVO> comments = commentService.getCommentList(nno);
			
			model.addAttribute("noticeVO", noticeVO);
			model.addAttribute("comments", comments); // 댓글들
			
			return ""; // notice 디테일 페이지
		}
		
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestBody CommentVO commentVO, HttpSession session, RedirectAttributes RA) {
		
		String userId = (String) session.getAttribute("userId");
		
		if(userId == null) {
			String doctorId = (String) session.getAttribute("doctorId");
			commentVO.setWriter(doctorId);
			commentVO.setUserOrDoctor("doctor");
		} else {
			commentVO.setWriter(userId);
		}
		
		CommentVO newComment = commentService.registComment(commentVO);
		
		if(newComment == null) {
			RA.addFlashAttribute("msg", "댓글 등록 중 문제가 발생했습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 에러 발생 게시글로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "정상 등록 됐습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 게시글로 리다이렉트
		}
		
	}
	
	@PostMapping("/registNotice")
	public String registNotice(NoticeVO noticeVO, RedirectAttributes RA) {
		
		NoticeVO newNoticeVO = noticeService.registNotice(noticeVO);
		
		if(newNoticeVO == null) {
			RA.addFlashAttribute("msg", "등록 중 문제가 발생했습니다");
			return "";
		} else {
			RA.addFlashAttribute("msg", "정상 등록 됐습니다");
			return "";
		}
		
	}
	
}
