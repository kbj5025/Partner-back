package com.example.minam.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Event {
	private long id;
	private String title;
	private String description;
	private String photoUrl;
	private String clinic;
	private String keyword;
	private String price;
	
}
