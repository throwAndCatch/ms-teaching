package com.replace;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReplaceConfig {
    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
