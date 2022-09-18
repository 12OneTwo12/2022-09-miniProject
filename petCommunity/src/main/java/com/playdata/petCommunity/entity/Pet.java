package com.playdata.petCommunity.entity;

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
@Table(name = "pet")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	
	@Column(length = 30, nullable = false)
	private String petName;
	
	@Column(length = 30, nullable = false)
	private String petBirth;
	
	@Column(length = 30, nullable = false)
	private String petNumber;
	
	@Column(length = 30)
	private String petWeight;
	
	@Column(length = 30, nullable = false)
	private String petCategory;
	
	@ManyToOne
	@JoinColumn(name="uno", referencedColumnName = "uno", nullable = false)
	private User user;
	
}
