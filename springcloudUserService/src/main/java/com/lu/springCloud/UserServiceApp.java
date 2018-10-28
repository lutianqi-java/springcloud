package com.lu.springCloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableCaching//开启缓存
public class UserServiceApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserServiceApp.class).web(true).run(args);
    }
}


