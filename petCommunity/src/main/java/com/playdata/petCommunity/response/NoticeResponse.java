package com.playdata.petCommunity.response;

import com.playdata.petCommunity.command.NoticeVO;
import com.playdata.petCommunity.entity.Notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeResponse {

	public NoticeVO updateNoticeVOByEntity(Notice notice) {
		return new NoticeVO(notice.getNno(), 
				notice.getWriter(), 
				notice.getTitle(), 
				notice.getContent(), 
				notice.getRegdate().toString(),
				notice.getNoticeState());
	}
	
}
