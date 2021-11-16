package com.example.minam.apply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor 
//Spring Data JPA(Java Persistence API, 자바 영속화 API)
@Entity
public class Apply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String clinicName;
	private String clinicSector;
	private String clinicLocate;
	private String registrationNumber;
	private String dateOfEstablishment;
	private String phone;
	private String email;
	private String applicantName;
	private String admissionApplicationDate;
}
