package com.demo.clients;

import org.springframework.stereotype.Component;

@Component
public class OrgClientImpl  implements OrgClient{

    public String getOrgById(String id) {
        return "feign降级";
    }

}
