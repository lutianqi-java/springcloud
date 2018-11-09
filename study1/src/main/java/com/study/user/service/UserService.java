package com.study.user.service;

import com.study.dao.UserJpa;
import com.study.entity.User;
import com.study.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {

    @Autowired
    UserJpa userJpa;


    @Autowired
    UserMapper userMapper;

    /**
     * 结合redis
     *
     * @return
     * @throws InterruptedException
     */
    @Cacheable("findAll")
    public List<User> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return userJpa.findAll();
    }

    public User selectById(String id) {
        return userMapper.selectById(id);
    }

    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }
}
