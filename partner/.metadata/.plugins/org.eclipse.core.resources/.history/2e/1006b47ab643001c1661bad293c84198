package com.example.minam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		// 추가된 객체를 반환
		events.put(currentId, eventItem);
		return eventItem;
	}
}
