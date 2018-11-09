package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.study1.mapper")
public class Study1Application {

    public static void main(String[] args) {
        SpringApplication.run(Study1Application.class, args);
    }
}
