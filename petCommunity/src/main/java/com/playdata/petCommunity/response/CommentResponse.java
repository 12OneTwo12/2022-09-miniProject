package com.playdata.petCommunity.response;

import com.playdata.petCommunity.command.CommentVO;
import com.playdata.petCommunity.entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {

	public CommentVO updateCommentVOByEntity(Comment comment) {
		return new CommentVO(comment.getWriter(), comment.getContent(), comment.getUserOrDoctor(),comment.getCommentState(), comment.getNotice().getNno());
	}
	
}
