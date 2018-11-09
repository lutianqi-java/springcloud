package com.study.dao;

import com.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, String> {
}
