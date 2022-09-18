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

	@CreatedDate // �����ð�
	@Column(updatable = false) // �ڵ� ������Ʈ�� ������� ����
	private LocalDateTime regdate;
	
	@LastModifiedDate // ������ ����ð�
	@Column
	private LocalDateTime moddate;
	
}
