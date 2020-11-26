package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrgZookeeperMain4001 {

    public static void main(String[] args) {
        SpringApplication.run(OrgZookeeperMain4001.class,args);
    }
}
