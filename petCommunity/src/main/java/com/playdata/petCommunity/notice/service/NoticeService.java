package com.playdata.petCommunity.notice.service;

import java.util.List;

import com.playdata.petCommunity.command.NoticeVO;
import com.playdata.petCommunity.util.page.Criteria;

public interface NoticeService {

	List<NoticeVO> getList(Criteria cri);

	List<NoticeVO> getListByWriter(Criteria cri);

	NoticeVO getDetailById(Long nno);

	NoticeVO registNotice(NoticeVO noticeVO);
	
	NoticeVO updateNotice(NoticeVO noticeVO,String userId);

	NoticeVO noticeDelete(NoticeVO noticeVO,String userId);

	boolean checkNotice(NoticeVO noticeVO, String userId);

}
