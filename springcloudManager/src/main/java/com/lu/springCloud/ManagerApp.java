package com.lu.springCloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(defaultConfiguration= FeignClientsConfiguration.class)
public class ManagerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ManagerApp.class).web(true).run(args);
    }
}


