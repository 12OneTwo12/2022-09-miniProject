package com.playdata.petCommunity.notice.service;

import java.util.List;

import com.playdata.petCommunity.command.NoticeVO;
import com.playdata.petCommunity.entity.Comment;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.util.page.Criteria;
import com.playdata.petCommunity.util.page.PageDTO;

public interface NoticeService {

	PageDTO<Notice> getList(Criteria cri);

	List<Notice> getListByWriter(Criteria cri);

	Notice getDetailById(Long nno);

}
