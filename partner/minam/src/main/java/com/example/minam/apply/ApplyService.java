package com.example.minam.apply;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplyService {
private RabbitTemplate rabbit;
	
	@Autowired
	public ApplyService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	public void sendApply(Apply reqApply) {
		System.out.println(reqApply);
		rabbit.convertAndSend("test.hello.2", reqApply);
	}

}
