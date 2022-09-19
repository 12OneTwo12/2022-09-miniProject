package com.playdata.petCommunity.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.comment.service.CommentService;
import com.playdata.petCommunity.entity.Comment;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.notice.service.NoticeService;
import com.playdata.petCommunity.util.page.Criteria;
import com.playdata.petCommunity.util.page.PageDTO;

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
		
		PageDTO<Notice> pageDTO = noticeService.getList(cri);
		
		System.out.println(pageDTO);
		
		model.addAttribute("pageDTO", pageDTO);
		
		return ""; // 전체 목록 조회 페이지
	}
	
	@RequestMapping("/noticeMyList")
	public String noticeMyList(Criteria cri, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return ""; // 작성자 id 값 없음으로 홈페이지로 리다이렉트
		} else {
			String userId = (String) session.getAttribute("userId");
			cri.setWriter(userId);
			List<Notice> list = noticeService.getListByWriter(cri);
			
			model.addAttribute("list", list);
			
			return ""; // user 자기 글 조회 목록 페이지
		}
		
	}
	
	@RequestMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("nno") Long nno, Model model, RedirectAttributes RA) {
		
		Notice notice = noticeService.getDetailById(nno);
		
		if(notice == null) {
			
			RA.addFlashAttribute("msg", "잘못된 조회 방법입니다");
			
			return ""; // nno 값으로 조회했을 때 없는 글, 홈페이지로 리다이렉트
		} else if(notice.getNoticeState().equals("삭제")){
			
			RA.addFlashAttribute("msg", "삭제된 게시글 입니다");
			
			return ""; // 삭제된 글이라고 메세지 뛰운 후 홈페이지로 리다이렉트
		} else {
			
			List<Comment> comments = commentService.getCommentList(nno);
			
			model.addAttribute("notice", notice);
			model.addAttribute("comments", comments); // 댓글들
			
			return ""; // notice 디테일 페이지
		}
		
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestParam("Notice") Notice notice, Comment comment, HttpSession session, RedirectAttributes RA) {
		
		String userId = (String) session.getAttribute("userId");
		comment.setWriter(userId);
		comment.setNotice(notice);
		
		Comment newComment = commentService.registComment(comment);
		
		if(newComment == null) {
			RA.addFlashAttribute("msg", "댓글 등록 중 문제가 발생했습니다");
			return "noticeDetail?nno="+notice.getNno(); // 에러 발생 게시글로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "정상 등록 됐습니다");
			return "noticeDetail?nno="+notice.getNno(); // 게시글로 리다이렉트
		}
		
	}
	
}
