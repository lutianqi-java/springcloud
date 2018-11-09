package com.study.dao;

import com.study.entity.LoggerInfos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJpa extends JpaRepository<LoggerInfos, String> {
}
