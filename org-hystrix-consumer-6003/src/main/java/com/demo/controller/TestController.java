package com.demo.controller;

import com.demo.clients.OrgClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hystrix/org")

public class TestController {

    @Resource
    private OrgClient orgClient;

    @GetMapping("/consumer/get/{id}")
    public String getOrgById(@PathVariable String id) {

        return orgClient.getOrgById(id);
    }

    public String doSth_fallback(String id) {

        return "消费端降级";
    }
}
