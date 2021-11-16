package com.example.minam.controller;

import java.util.List;

import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EventController {
	
private EventRepository repo;
	
	@Autowired
	public EventController(EventRepository repo) {
		this.repo = repo;
	}
	
	// 목록조회
	// GET/events
	@GetMapping(value = "/events")
	public List<Event> getEvents() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
	
	// 1건 추가
	// POST / events
	@PostMapping(value = "/events")
	public Event addEvent(@RequestBody Event event, HttpServletResponse res) throws InterruptedException {
		
		// 입력받은 데이터로 객체를 생성
		Event eventItem = Event.builder().title(event.getTitle()).description(event.getDescription()).photoUrl(event.getPhotoUrl()).fileType(event.getFileType())
				.fileName(event.getFileName()).clinic(event.getClinic()).keyword(event.getKeyword()).price(event.getPrice()).build();
		// 목록 객체 추가
		Event eventSaved = repo.save(eventItem);

		// 리소스 생성됨
		// res.setStatus(201);
		res.setStatus(HttpServletResponse.SC_CREATED);
		
		return eventSaved;
	}
	
	// 1건 수정
	// PUT /events/1 , id값이 path variable로
	@PutMapping(value = "/events/{id}")
	public Event modifyEvent(@PathVariable long id, @RequestBody Event event, HttpServletResponse res) throws InterruptedException {
		
		Optional<Event> eventItem = repo.findById(id);
		if(eventItem.isEmpty()) {
			// NOT FOUND: 해당 경로에 리소스가 없음
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		Event eventToSave = eventItem.get();
		
		eventToSave.setTitle(event.getTitle());
		eventToSave.setDescription(event.getDescription());
		eventToSave.setPhotoUrl(event.getPhotoUrl());
		eventToSave.setClinic(event.getClinic());
		eventToSave.setPrice(event.getPrice());
		eventToSave.setKeyword(event.getKeyword());
		eventToSave.setFileType(event.getFileType());	
		eventToSave.setFileName(event.getFileName());	
	
		Event eventSaved = repo.save(eventToSave);
		
		return eventSaved;
	}
	
	// 1건 삭제
	// DELETE /events/1 ->id가 1인 항목 삭제
	@DeleteMapping(value= "/events/{id}")
	public boolean removeTodo(@PathVariable long id, HttpServletResponse res) throws InterruptedException {
		
		Optional<Event> event = repo.findById(id);
		// 해당 id의 데이터가 없으면
		if (event.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// 삭제 수행
		repo.deleteById(id);
		
		return true;
	}
	
	
	
	
	
}
