package com.lu.springCloud.feign;

import com.lu.springCloud.hystrix.FeignHystrixClientFailback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "userService", fallback = FeignHystrixClientFailback.class)
public interface TestFeign {

    @RequestMapping("/index")
    Map<String,Object> index();
}
