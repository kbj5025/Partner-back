package com.example.minam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	public SortedMap<Long,Event> events = 
			Collections.synchronizedSortedMap(new TreeMap<Long,Event>(Collections.reverseOrder()));
	
	//id값 생성에 사용할 변수
	public AtomicLong maxId = new AtomicLong();
	
	// 목록조회
	// GET/events
	@GetMapping(value = "/events")
	public List<Event> getEvents(){
	return new ArrayList<Event>(events.values());
} 
	
	// 1건 추가
	// POST / events
	@PostMapping(value = "/events")
	public Event addEvent(@RequestBody Event event, HttpServletResponse res) {
		// id 값을 생성
		Long currentId = maxId.incrementAndGet();
		// 입력받은 데이터로 객체를 생성
		Event eventItem = Event.builder().id(currentId).title(event.getTitle()).description(event.getDescription()).photoUrl(event.getPhotoUrl()).clinic(event.getClinic()).keyword(event.getKeyword()).price(event.getPrice()).build();
		// 목록 객체 추가
		events.put(currentId, eventItem);

		// 리소스 생성됨
		// res.setStatus(201);
		res.setStatus(HttpServletResponse.SC_CREATED);
		
		return eventItem;
	}
	
	// 1건 수정
	// PUT /events/1 , id값이 path variable로
	@PutMapping(value = "/events/{id}")
	public Event modifyEvent(@PathVariable long id, @RequestBody Event event, HttpServletResponse res) {
		// 해당 id의 데이터 1건 가져옴
		Event findItem = events.get(Long.valueOf(id));
		// 해당 id의 데이터가 없으면
		if(findItem == null) {
			// NOT FOUND: 해당 경로에 리소스가 없음
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		findItem.setTitle(event.getTitle());
		findItem.setDescription(event.getDescription());
		findItem.setPhotoUrl(event.getPhotoUrl());
		findItem.setClinic(event.getClinic());
		findItem.setPrice(event.getPrice());
		findItem.setKeyword(event.getKeyword());
		return findItem;
	}
	
	// 1건 삭제
	// DELETE /events/1 ->id가 1인 항목 삭제
	@DeleteMapping(value= "/events/{id}")
	public boolean removeTodo(@PathVariable long id, HttpServletResponse res) {
		// 해당 id의 데이터 1건 가져옴
		Event event = events.get(Long.valueOf(id));
		// 해당 id의 데이터가 없으면
		if (event == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// 삭제 수행
		events.remove(Long.valueOf(id));
		
		return true;
	}
	
	
	
	
	
}
