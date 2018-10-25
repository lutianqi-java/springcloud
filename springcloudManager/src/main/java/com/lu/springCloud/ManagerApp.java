package com.lu.springCloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(defaultConfiguration= FeignClientsConfiguration.class)
public class ManagerApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ManagerApp.class).web(true).run(args);
    }

//     这里定义 可以覆盖所有的
     @Bean
     public IRule ribbonRule() {
     return new RandomRule();
     }
}


