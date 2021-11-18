package com.example.minam.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	private RabbitTemplate rabbit;
	
	@Autowired
	public EventService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	public void sendEvent(Event reqEvent) {
		System.out.println(reqEvent);
//		rabbit.convertAndSend("test.hello.2", reqEvent);
		rabbit.convertAndSend("test.hello.1", reqEvent);
	}
}
