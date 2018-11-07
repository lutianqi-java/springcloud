package com.study.study1.dao;

import com.study.study1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends
        JpaRepository<User, String>
         {
}
