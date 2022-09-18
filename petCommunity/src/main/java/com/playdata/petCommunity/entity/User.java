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
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uno;
	
	@Column(length = 30, nullable = false)
	private String userName;
	
	@Column(length = 30, nullable = false)
	private String userPhoneNumber;
	
	@Column(length = 30, nullable = false)
	private String userId;
	
	@Column(length = 30, nullable = false)
	private String userPw;
	
	@Column(length = 300)
	private String userLocation;
	
}
