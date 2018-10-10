package com.example.demo.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.client.UserClient;
import com.example.demo.model.User;

@Component
public class UserFallBack implements UserClient {

	@Override
	public int getPort() {
		return 0;
	}

	@Override
	public List<User> findAllUser() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setUsername("none");
		list.add(user);
		return list;
	}

}
