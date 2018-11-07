package com.study.study1.controller;

import com.study.study1.dao.UserDao;
import com.study.study1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("findAll")
    public List<User> findAll() {
        return userDao.findAll();
    }

    @RequestMapping("save")
    public User save() {
        User user = new User();
        user.setAddress("测试地址");
        user.setAge("111");
        user.setName("测试姓名");
        return userDao.save(user);
    }

}
