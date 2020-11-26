package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain7001.class,args);
    }
}
