package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        System.out.println("hello world");
        System.out.println("welcome从 ");
        System.out.println("test");
        return "hello world";
    }

}
