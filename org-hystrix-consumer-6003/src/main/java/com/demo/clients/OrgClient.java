package com.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "ORG-HYSTRIX",fallback =OrgClientImpl.class )
public interface OrgClient {


    @GetMapping("/hystrix/org/get/{id}")
    String getOrgById(@PathVariable("id") String id);
}
