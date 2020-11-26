package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public String getOrgById(@PathVariable String id){

        return serverPort+":"+id;
    }
}
