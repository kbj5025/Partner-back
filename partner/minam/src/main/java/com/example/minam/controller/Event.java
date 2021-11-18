package com.example.minam.controller;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor 
// Spring Data JPA(Java Persistence API, 자바 영속화 API)
// @Entity : 테이블과 클래스를 맵핑
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private String clinic;
	private String keyword;
	private String price;
	
	@Column(columnDefinition = "TEXT")
	private String photoUrl;
	private String fileType;
	private String fileName;
	private Long createdTime;
	
}
