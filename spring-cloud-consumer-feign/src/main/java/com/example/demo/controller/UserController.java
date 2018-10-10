package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.client.UserClient;
import com.example.demo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="/User", tags="用户模块接口")
@Controller
public class UserController {
	
	@Autowired
	private UserClient userClient;

	@ApiOperation(value="获取端口号", notes="通过feign访问服务的端口号")
	@RequestMapping("/getPort")
	@ResponseBody
	public int getPort() {
		return userClient.getPort();
	}
	
	@ApiOperation(value="id", notes="")
	@RequestMapping("/user/{id}")
	@ResponseBody
	public String show(@PathVariable(value="id") String id) {
		return id;
	}
	
	
	@ApiImplicitParam(name="user", value="this is a user", required = true, dataType = "User")
	@RequestMapping("/user/addName")
	@ResponseBody
	public User addName(User user) {
		return user;
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<User> findAllUser() {
		return userClient.findAllUser();
	}
}
