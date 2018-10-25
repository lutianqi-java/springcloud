package com.lu.springCloud.hystrix;

import com.lu.springCloud.feign.TestFeign;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FeignHystrixClientFailback implements TestFeign {
    @Override
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test1", "调用异常");
        map.put("test2", "22222");
        return map;
    }
}
