package com.playdata.petCommunity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notice")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Notice extends BaseNoticeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long nno;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	@Column(length = 300, nullable = false)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	@Column(columnDefinition = "varchar(30) default '정상 등록'")
	private String noticeState;
	
}
