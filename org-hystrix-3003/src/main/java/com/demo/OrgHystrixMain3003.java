package com.demo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class OrgHystrixMain3003 {
    public static void main(String[] args) {
        SpringApplication.run(OrgHystrixMain3003.class, args);
    }



    @Bean
    public  ServletRegistrationBean servletRegistrationBean(){
        HystrixMetricsStreamServlet  hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean s = new ServletRegistrationBean(hystrixMetricsStreamServlet);

        s.setLoadOnStartup(1);
        s.addUrlMappings("/hystrix.stream");
        s.setName("HystrixMetricsStreamServlet");
        return s;
    }

}
