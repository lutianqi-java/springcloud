package com.lu.springCloud.controller;

import com.lu.springCloud.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    TestFeign testFeign;

    @RequestMapping(value = "index")
    public Map<String, Object> index() {
        return testFeign.index();
    }
}
