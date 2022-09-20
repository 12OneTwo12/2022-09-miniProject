package com.playdata.petCommunity.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentVO {

	private Long cno;
	
	private String writer;
	
	private String content;
	
	private String userOrDoctor;
	
	private String commentState;
	
	private Long nno;
	
}
