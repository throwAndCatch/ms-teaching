package com.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {


    @HystrixCommand(fallbackMethod = "doSth_fallback",commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String doSth(String id){
        try {
            int result = 1/0;
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e) {}
        return Thread.currentThread().getName()+":"+id;
    }
    public String doSth_fallback(String id){

        return "这是服务提供方降级方法";
    }


    @HystrixCommand(fallbackMethod = "doSth_break_aa",commandProperties ={
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String doSth_break(Integer id) throws Exception {
       if(id> 0){
           return String.valueOf(id);
       }else{
           throw  new Exception();
       }
    }
    public String doSth_break_aa(Integer id){

        return "熔断："+id;
    }

}
