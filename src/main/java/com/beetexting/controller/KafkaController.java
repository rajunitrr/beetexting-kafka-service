package com.beetexting.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beetexting.dto.User;
import com.beetexting.event.BeetextingEvent;
import com.beetexting.producer.KafkaProducer;
import com.beetexting.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/kafka")
@Slf4j
public class KafkaController {

    private final KafkaProducer producer;
    
   
    private final UserService userService;

    public KafkaController(KafkaProducer producer,UserService userService) {
        this.producer = producer;
        this.userService=userService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
    	
    	
    	List<User> users=userService.getUsers();
    	
    	BeetextingEvent beetextingEvent = BeetextingEvent.builder().partner("rc").payload(users).build();
    	
    	log.info("User Deatails"+users);
    	
    	
        producer.send(beetextingEvent);
        
        
        return "Message sent: " + message;
    }
}