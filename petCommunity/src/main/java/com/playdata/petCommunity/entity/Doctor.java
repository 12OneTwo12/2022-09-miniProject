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
@Table(name = "doctor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long dno;
	
	@Column(length = 30, nullable = false)
	private String doctorName;
	
	@Column(length = 30, nullable = false)
	private String doctorNumber;
	
	@Column(length = 30, nullable = false)
	private String doctorId;
	
	@Column(length = 30, nullable = false)
	private String doctorPw;
	
	@Column(length = 300)
	private String doctorLocation;
	
	@Column(columnDefinition = "int default '0'")
	private Long doctorRecommend;
	
}
