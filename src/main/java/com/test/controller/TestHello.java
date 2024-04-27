package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class TestHello {
    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
    @ResponseBody
    @GetMapping("/hi")
    public String sayHe(){
        return "你好！tom";
    }
}
