package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrgConsumerFeign6002 {
    public static void main(String[] args) {
        SpringApplication.run(OrgConsumerFeign6002.class,args);
    }
}
