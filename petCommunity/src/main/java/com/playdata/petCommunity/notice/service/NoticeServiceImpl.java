package com.playdata.petCommunity.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.playdata.petCommunity.entity.Comment;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.entity.QNotice;
import com.playdata.petCommunity.util.page.Criteria;
import com.playdata.petCommunity.util.page.PageDTO;
import com.querydsl.core.BooleanBuilder;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Override
	public PageDTO<Notice> getList(Criteria cri) {
		
		// 동적쿼리를 만듬
		QNotice qNotice = QNotice.notice;
		
		// 조건을 조합할 불린빌더
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qNotice.noticeState.contains("정상 등록"));
		
		// ID에 값이 있다면? express로 표현
		if(cri.getWriter() != null && !cri.getWriter().equals("")) {
			builder.and(qNotice.writer.like("%"+cri.getWriter()+"%"));
		} 
		
		if (cri.getContent() != null && !cri.getContent().equals("")) {
			builder.and(qNotice.content.like("%"+cri.getContent()+"%"));
		}
		
		if (cri.getTitle() != null && !cri.getTitle().equals("")) {
			builder.and(qNotice.title.like("%"+cri.getTitle()+"%"));
		}
		
		Page<Notice> result = noticeRepository.findAll(builder, PageRequest.of(cri.getPage()-1, cri.getAmount(), Sort.by("nno").descending()));
		
		PageDTO<Notice> pageDTO = new PageDTO<>(result);
		
		return pageDTO;
	}

	@Override
	public List<Notice> getListByWriter(Criteria cri) {
		
		QNotice qNotice = QNotice.notice;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(qNotice.noticeState.contains("정상 등록"));
		
		builder.and(qNotice.writer.contains(cri.getWriter()));
		
		return noticeRepository.findAll(builder,PageRequest.of(cri.getPage()-1, cri.getAmount(), Sort.by("nno").descending())).getContent();
	}

	@Override
	public Notice getDetailById(Long nno) {
		return noticeRepository.findById(nno).get();
	}

}
