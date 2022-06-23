package com.study.provider;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

//@EnableEurekaClient //如果配置了注册中心，则会默认开启，无需使用该注解
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignApplication {

    // 全局负载均衡采用 随机策略
//    @Bean
//    public RandomRule randomRule() {
//        return new RandomRule();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }

}
