package com.lu.springCloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = "index")
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "1111");
        return map;
    }
}
