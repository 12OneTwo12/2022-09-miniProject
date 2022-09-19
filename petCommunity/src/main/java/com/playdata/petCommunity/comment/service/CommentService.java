package com.playdata.petCommunity.comment.service;

import java.util.List;

import com.playdata.petCommunity.entity.Comment;

public interface CommentService {

	List<Comment> getCommentList(Long nno);

	Comment registComment(Comment comment);

}
