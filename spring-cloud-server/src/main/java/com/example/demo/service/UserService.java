package com.example.demo.service;


import java.util.List;

import com.example.demo.model.User;


public interface UserService {

	User findByName(String username);
	
	int insert(String username, Integer age);
	
	List<User> findAll();
	
	String redisCache(int id);
	
	/*String requestDelay();
	
	String getUser(int id);*/
}
