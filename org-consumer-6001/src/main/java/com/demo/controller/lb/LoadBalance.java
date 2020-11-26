package com.demo.controller.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {



    ServiceInstance intances(List<ServiceInstance> list);
}
