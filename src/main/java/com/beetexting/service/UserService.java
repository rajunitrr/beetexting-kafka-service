package com.beetexting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beetexting.dto.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	public List<User> getUsers() {

		List<User> users = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			User user = User.builder()
					        .username("user" + i)
					        .city("City" + i)
					        .state("State" + i)
					        .country("Country" + i)
					.phoneNumber(1000000000L + i).build();

			users.add(user);
			
			try {
	            Thread.sleep(0); // Introduce 100ms delay
	        } catch (InterruptedException e) {
	            throw new RuntimeException("Thread interrupted while creating users", e);
	        }
		}
		return users;
	}

}
