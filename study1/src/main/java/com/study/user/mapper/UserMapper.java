package com.study.user.mapper;

import com.study.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectById(String id);

    void insert(User user);
}
