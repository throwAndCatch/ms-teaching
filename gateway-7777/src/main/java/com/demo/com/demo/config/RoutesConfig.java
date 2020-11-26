package com.demo.com.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RoutesConfig {

//    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().route("test_001",
                r -> r.path("/org/get/**").uri("lb://org")
        ).build();
    }
}
