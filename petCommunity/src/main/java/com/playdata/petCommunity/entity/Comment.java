package com.playdata.petCommunity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comment")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long cno;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	@Column(length = 2000)
	private String content;
	
	@Column(length = 20)
	private String noticedate;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="nno", columnDefinition ="VARCHAR(36)", nullable = false)
	private Long nno;
	
}
