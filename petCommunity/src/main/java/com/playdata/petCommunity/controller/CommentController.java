package com.playdata.petCommunity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playdata.petCommunity.command.CommentVO;
import com.playdata.petCommunity.comment.service.CommentService;

@Controller
@RequestMapping("/commnet")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@PostMapping("/addComment")
	public String addComment(@RequestBody CommentVO commentVO, HttpSession session, RedirectAttributes RA) {
		
		CommentVO newComment = commentService.registComment(session, commentVO);
		
		if(newComment == null) {
			RA.addFlashAttribute("msg", "댓글 등록 중 문제가 발생했습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 에러 발생 게시글로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "정상 등록 됐습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 게시글로 리다이렉트
		}
		
	}
	
	@PostMapping("/updateComment")
	public String updateComment(@RequestBody CommentVO commentVO, HttpSession session, RedirectAttributes RA) {
		
		CommentVO updateComment = commentService.updateComment(session, commentVO);
		
		if(updateComment == null) {
			RA.addFlashAttribute("msg", "댓글 수정 중 문제가 발생했습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 에러 발생 게시글로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "정상적으로 수정 됐습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 게시글로 리다이렉트
		}
		
	}
	
	@PostMapping("/deleteComment")
	public String deleteComment(@RequestBody CommentVO commentVO, HttpSession session, RedirectAttributes RA) {
		
		CommentVO deleteComment = commentService.deleteComment(session, commentVO);
		
		if(deleteComment == null) {
			RA.addFlashAttribute("msg", "댓글 삭제 중 문제가 발생했습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 에러 발생 게시글로 리다이렉트
		} else {
			RA.addFlashAttribute("msg", "정상적으로 삭제 됐습니다");
			return "noticeDetail?nno="+commentVO.getNno(); // 게시글로 리다이렉트
		}
		
	}
	
}
