package com.example.minam.reserve;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class ReserveResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String rezName;
	private String rezPhone;
	private String seeDate;
	private String seeTime;
	private String eventId;
}
