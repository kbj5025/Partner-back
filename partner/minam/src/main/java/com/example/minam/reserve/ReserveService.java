package com.example.minam.reserve;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReserveService {
	private RabbitTemplate rabbit;
	
	 ReserveRepository repo;
	  
	@Autowired
	public ReserveService(ReserveRepository repo, RabbitTemplate rabbit) {
		this.repo = repo;
		this.rabbit = rabbit;
	}
	
	   @RabbitListener(queues = "test.hello.3")
	   public void receiveReserve(Reserve reserve) {
	      System.out.println(reserve);
	      saveReserve(reserve);
	   }

	   public Reserve saveReserve(Reserve resReserve) {
			Reserve reserve = Reserve.builder().rezName(resReserve.getRezName()).rezPhone(resReserve.getRezPhone())
					.seeDate(resReserve.getSeeDate()).seeTime(resReserve.getSeeTime()).eventId(resReserve.getEventId())
					.build();
			repo.save(reserve);
			return reserve;
		}
}
