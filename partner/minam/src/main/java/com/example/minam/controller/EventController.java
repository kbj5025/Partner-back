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
	
	// �����ȸ
	// GET/events
	@GetMapping(value = "/events")
	public List<Event> getEvents() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}
	
	// 1�� �߰�
	// POST / events
	@PostMapping(value = "/events")
	public Event addEvent(@RequestBody Event event, HttpServletResponse res) throws InterruptedException {
		
		// �Է¹��� �����ͷ� ��ü�� ����
		Event eventItem = Event.builder().title(event.getTitle()).description(event.getDescription()).photoUrl(event.getPhotoUrl()).fileType(event.getFileType())
				.fileName(event.getFileName()).clinic(event.getClinic()).keyword(event.getKeyword()).price(event.getPrice()).build();
		// ��� ��ü �߰�
		Event eventSaved = repo.save(eventItem);

		// ���ҽ� ������
		// res.setStatus(201);
		res.setStatus(HttpServletResponse.SC_CREATED);
		
		return eventSaved;
	}
	
	// 1�� ����
	// PUT /events/1 , id���� path variable��
	@PutMapping(value = "/events/{id}")
	public Event modifyEvent(@PathVariable long id, @RequestBody Event event, HttpServletResponse res) throws InterruptedException {
		
		Optional<Event> eventItem = repo.findById(id);
		if(eventItem.isEmpty()) {
			// NOT FOUND: �ش� ��ο� ���ҽ��� ����
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
	
	// 1�� ����
	// DELETE /events/1 ->id�� 1�� �׸� ����
	@DeleteMapping(value= "/events/{id}")
	public boolean removeTodo(@PathVariable long id, HttpServletResponse res) throws InterruptedException {
		
		Optional<Event> event = repo.findById(id);
		// �ش� id�� �����Ͱ� ������
		if (event.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// ���� ����
		repo.deleteById(id);
		
		return true;
	}
	
	
	
	
	
}
