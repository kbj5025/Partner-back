package com.example.minam.reserve;


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
public class Reserve {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String rezName;
	private String rezPhone;
	private String seeDate;
	private String seeTime;
	private String eventId;
	
	
}

