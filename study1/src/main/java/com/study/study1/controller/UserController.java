package com.study.study1.controller;

import com.study.study1.dao.UserJpa;
import com.study.study1.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserJpa userDao;

    @RequestMapping("findAll")
    public List<User> findAll() {
        return userDao.findAll();
    }

    @RequestMapping("save")
    public User save() {
        logger.info("保存");
        logger.debug("保存");
        logger.error("保存");
        User user = new User();
        user.setAddress("测试地址");
        user.setAge("111");
        user.setName("测试姓名");
        return userDao.save(user);
    }

}
