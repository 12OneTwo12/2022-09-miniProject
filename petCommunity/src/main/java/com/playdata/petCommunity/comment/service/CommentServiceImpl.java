package com.playdata.petCommunity.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.entity.Comment;
import com.playdata.petCommunity.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comment> getCommentList(Long nno) {
		return commentRepository.findByNno(nno);
	}

	@Override
	public Comment registComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
