package com.demo.controller.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int incrementAndGetModulo() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;

        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("调用次数：" + next);
        return next;
    }


    public ServiceInstance intances(List<ServiceInstance> list) {
        return list.get(incrementAndGetModulo() % list.size());

    }
}
