package com.lu.springCloud.service;

import com.lu.springCloud.entity.User;
import com.lu.springCloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    public User findById(String id){
        return userMapper.findById(id);
    }

    public int addUser(String name,String age){
        return userMapper.addUser(name,age);
    }

    public void updataById(String id,String name){
        userMapper.updataById(id,name);
    }

    public void deleteById(String id){
        userMapper.deleteById(id);
    }
}
