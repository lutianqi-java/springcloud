package com.study.study1.service;

import com.study.study1.dao.UserJpa;
import com.study.study1.entity.User;
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

    /**
     * 结合redis
     * @return
     * @throws InterruptedException
     */
    @Cacheable("findAll")
    public List<User> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return userJpa.findAll();
    }

}
