package com.study.provider;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableEurekaClient //如果配置了注册中心，则会默认开启，无需使用该注解
@SpringBootApplication
public class ConsumerApplication {

    @Bean
    @LoadBalanced  // 这个开启后，默认使用 轮询策略
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 全局负载均衡采用 随机策略
//    @Bean
//    public RandomRule randomRule() {
//        return new RandomRule();
//    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
