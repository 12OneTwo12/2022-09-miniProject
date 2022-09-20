package com.playdata.petCommunity.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.command.CommentVO;
import com.playdata.petCommunity.entity.Comment;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.repository.CommentRepository;
import com.playdata.petCommunity.repository.NoticeRepository;
import com.playdata.petCommunity.response.CommentResponse;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	NoticeRepository noticeRepository;

	@Override
	public List<CommentVO> getCommentList(Long nno) {
		
		List<Comment> list = commentRepository.findByNno(nno);
		
		List<CommentVO> result = new ArrayList<>();
		
		for(Comment c : list) {
			result.add(new CommentResponse().updateCommentVOByEntity(c));
		}
		
		return result;
	}

	@Override
	public CommentVO registComment(CommentVO commentVO) {
		
		Notice notice = noticeRepository.findById(commentVO.getNno()).get();
		
		Comment comment = new Comment().updateCommentByVO(commentVO, notice);
		
		Comment saved = commentRepository.save(comment);
		
		return new CommentResponse().updateCommentVOByEntity(saved);
	}

}
