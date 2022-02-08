package com.example.consumer.controller;

import com.example.service.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("")
public class HelloController {

    @DubboReference()
    IHelloService helloService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(String name) {
        return "consumer:" + helloService.hello(name);
    }
}
