package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/find")
	@ResponseBody
	public User findUser() {
		return userService.findByName("d");
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<User> findAllUser() {
		return userService.findAll();
	}

	@RequestMapping("/serverPort")
	@ResponseBody
	public int getPort(HttpServletRequest request) {
		return request.getServerPort();
	}
	
	/*@RequestMapping("/requestDelay")
	@ResponseBody
	public String requestDelay() {
		return userService.requestDelay();
	}*/
	
	@RequestMapping("/redisCache")
	@ResponseBody
    public String redisCache() {
		long startTime = System.currentTimeMillis();
		System.out.println("*****************************");
		System.out.println(startTime);
		String str = userService.redisCache(001);
		System.out.println(System.currentTimeMillis());
		System.out.println("*****************************");
        return str + ": " + (System.currentTimeMillis()-startTime) + "ms";
    }
	
	/**
     * redis sesion共享
     * @param request
     * @return
     */
    @GetMapping("/getUserName")
	@ResponseBody
    public String getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(StringUtils.isEmpty(username)){
            session.setAttribute("username", "testSessionRedis|" + System.currentTimeMillis());
        }
        return username;
    }

	
}
