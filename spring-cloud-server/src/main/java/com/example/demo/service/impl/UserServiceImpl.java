package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

	
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByName(username);
	}

	
	public int insert(String username, Integer age) {
		// TODO Auto-generated method stub
		return userMapper.insert(username, age);
	}

	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}
//, unless = "#result==null"
	
	@Cacheable(value = "redis_cache", key ="#id")
    public String redisCache(int id) {
		//System.out.println("redis*****************************");
		//System.out.println(System.currentTimeMillis());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(System.currentTimeMillis());
		//System.out.println("redis*****************************");
        return "redis cache";
    }

	/*@Cacheable("user")
	public String requestDelay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "延迟时间：";
	}*/
	
	

}
