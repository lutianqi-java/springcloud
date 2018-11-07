package com.study.study1.dao;

import com.study.study1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJpa extends JpaRepository<User, String> {
}
