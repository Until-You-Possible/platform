package com.wanggang.platform.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "123";
    }

}
