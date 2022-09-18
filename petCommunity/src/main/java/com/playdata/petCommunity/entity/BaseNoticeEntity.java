package com.playdata.petCommunity.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass 
@EntityListeners(AuditingEntityListener.class) 
@Getter
public class BaseNoticeEntity {

	@CreatedDate // 생성시간
	@Column(updatable = false) // 자동 업데이트를 사용하지 않음
	private LocalDateTime regdate;
	
	@LastModifiedDate // 마지막 변경시간
	@Column
	private LocalDateTime moddate;
	
}
