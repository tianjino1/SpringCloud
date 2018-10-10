package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.demo.model.User;


public interface UserMapper {

    User findByName(@Param("username") String username);

    int insert(@Param("username") String username, @Param("age") Integer age);
    
    List<User> findAll();

}