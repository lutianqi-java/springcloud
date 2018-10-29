package com.study.study1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.Map;

/**
 * url   测试
 */
@RestController
public class TestController {

    /**
     * 普通rest 测试
     * @param id
     * @return
     */
    @RequestMapping(value = "/index/{id}.json")
    @ResponseBody
    public String index(@PathVariable("id")String id){

        return id+"test";
    }

    @RequestMapping(value = "/indexs/*.json")
    public String index1(){
        return "11111";
    }

    @RequestMapping(value = "/indexs/2*.json")
    public String index2(){
        return "222";
    }
    @RequestMapping(value = "/index3",consumes = "application/json")
    public String index3(){
        return "222";
    }

    @RequestMapping(value = "/index4")
    public String index4(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("test","111");
        model.addAllAttributes(map);
        return "/user.ftl";
    }


    @RequestMapping(value = "/index5")
    public String index5(@NotNull String id){

        return "/user.ftl";
    }


}
