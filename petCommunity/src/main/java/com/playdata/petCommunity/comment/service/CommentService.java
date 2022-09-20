package com.playdata.petCommunity.comment.service;

import java.util.List;

import com.playdata.petCommunity.command.CommentVO;

public interface CommentService {

	List<CommentVO> getCommentList(Long nno);

	CommentVO registComment(CommentVO commentVO);

}
