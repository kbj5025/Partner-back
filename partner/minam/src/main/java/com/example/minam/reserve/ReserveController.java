package com.example.minam.reserve;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ReserveController {
	
private ReserveRepository repo;
private ReserveService service;
	
	@Autowired
	public ReserveController(ReserveRepository repo, ReserveService service) {
		this.repo = repo;
		this.service = service;
	}
	
	// 목록조회
	// GET
	@GetMapping(value = "/reserves")
	public List<Reserve> getReserves() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}

}
