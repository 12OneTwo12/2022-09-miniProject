package com.playdata.petCommunity;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.playdata.petCommunity.comment.service.CommentRepository;
import com.playdata.petCommunity.entity.Notice;
import com.playdata.petCommunity.entity.QNotice;
import com.playdata.petCommunity.notice.service.NoticeRepository;
import com.playdata.petCommunity.util.page.Criteria;
import com.playdata.petCommunity.util.page.PageDTO;
import com.querydsl.core.BooleanBuilder;

@SpringBootTest
public class NoticeTest {
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	CommentRepository commentRepository;

//	@Test
//	public void testCode01() {
//		
//		QNotice qNotice = QNotice.notice;
//		
//		Criteria cri = new Criteria();
//
//		// 조건을 조합할 불린빌더
//		BooleanBuilder builder = new BooleanBuilder();
//		builder.and(qNotice.noticeState.contains("정상 등록"));
//		
//		// ID에 값이 있다면? express로 표현
//		if(cri.getWriter() != null && !cri.getWriter().equals("")) {
//			builder.and(qNotice.writer.like("%"+cri.getWriter()+"%"));
//		} 
//		
//		if (cri.getContent() != null && !cri.getContent().equals("")) {
//			builder.and(qNotice.content.like("%"+cri.getContent()+"%"));
//		}
//		
//		if (cri.getTitle() != null && !cri.getTitle().equals("")) {
//			builder.and(qNotice.title.like("%"+cri.getTitle()+"%"));
//		}
//		
//		Page<Notice> result = noticeRepository.findAll(builder, PageRequest.of(cri.getPage()-1, cri.getAmount(), Sort.by("nno").descending()));
//		
//		PageDTO<Notice> pageDTO = new PageDTO<>(result);
//		
//		System.out.println(pageDTO);
//		
//	}
	
//	@Test
//	public void testCode02() {
//		
//		Criteria cri = new Criteria();
//		
//		cri.setWriter("정정일");
//		
//		List<Notice> list = noticeRepository.findByWriter(cri.getWriter(), PageRequest.of(cri.getPage()-1, cri.getAmount(), Sort.by("nno").descending())).getContent();
//	
//		System.out.println(list);
//	}
	
//	@Test
//	public void testCode03() {
//		Criteria cri = new Criteria();
//		
//		QNotice qNotice = QNotice.notice;
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		builder.and(qNotice.noticeState.contains("정상 등록"));
//		
//		builder.and(qNotice.writer.contains("정정일"));
//		
//		List<Notice> list = noticeRepository.findAll(builder,PageRequest.of(cri.getPage()-1, cri.getAmount(), Sort.by("nno").descending())).getContent();
//	
//		System.out.println(list);
//	}
	
//	@Test
//	public void testCode04() {
//		
//		System.out.println(noticeRepository.findByIdWithoutDelete(1L));
//		
//	}
	
//	@Test
//	public void testCode05() {
//		System.out.println(commentRepository.findByNno(1L));
//	}
	
}
