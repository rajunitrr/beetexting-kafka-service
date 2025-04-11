package com.beetexting.consumer;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.beetexting.dto.User;
import com.beetexting.event.BeetextingEvent;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "my-topic", groupId = "test-group")
	public void receive(BeetextingEvent event) {
		System.out.println("Consumed message: " + event);

		List<User> users = (List<User>) event.getPayload();

		users.forEach(user -> System.out.println(user));
	}

}