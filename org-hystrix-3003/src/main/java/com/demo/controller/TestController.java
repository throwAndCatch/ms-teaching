package com.demo.controller;

import com.demo.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hystrix/org")
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    TestService service;


    @GetMapping("/get/{id}")
    public String getOrgById(@PathVariable String id){

        return service.doSth(id);
    }


    @GetMapping("/get/break/{id}")
    public String getOrgById(@PathVariable Integer id) throws Exception {

        return service.doSth_break(id);
    }
}
