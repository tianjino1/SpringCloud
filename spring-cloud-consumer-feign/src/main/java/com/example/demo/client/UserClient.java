package com.example.demo.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.fallback.UserFallBack;
import com.example.demo.model.User;

@FeignClient(value="server", fallback=UserFallBack.class)
public interface UserClient {
	
	@RequestMapping("/serverPort")
	public int getPort();
	
	@RequestMapping("/findAll")
	public List<User> findAllUser();
}
