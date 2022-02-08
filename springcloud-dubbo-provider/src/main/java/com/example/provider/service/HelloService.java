package com.example.provider.service;

import com.example.service.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloService implements IHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + " by provider";
    }
}
