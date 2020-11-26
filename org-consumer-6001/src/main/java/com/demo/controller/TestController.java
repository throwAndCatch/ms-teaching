package com.demo.controller;

import com.demo.controller.lb.CustomLB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/org")
public class TestController {


    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CustomLB customLB;


    private static String url ="http://ORG//org/get";

    @GetMapping("/get/{id}")
    public String getOrgById(@PathVariable String id){

//        List<ServiceInstance> org = discoveryClient.getInstances("ORG");
//
//        ServiceInstance intances = customLB.intances(org);
//        return String.valueOf(intances.getPort());
//        return restTemplate.getForObject(intances.getPort()+"//org/get/1",String.class);


        return  restTemplate.getForObject(url+"/"+id,String.class);
    }
}
