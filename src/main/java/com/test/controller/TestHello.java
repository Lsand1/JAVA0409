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
    public String sayHello(){return "Hell";}
    @ResponseBody
    @GetMapping("/aa")
    public String sayHe(){ return  "你好";}
    @ResponseBody
    @GetMapping("/fenzhi")
    public String fenzhi(){
        System.out.print("分支1");
        return  "你好";
    }
    }
