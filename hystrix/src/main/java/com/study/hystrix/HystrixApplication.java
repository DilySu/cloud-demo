package com.study.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


//@EnableHystrix // 开启熔断
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.study.provider.service",
        "com.study.hystrix"
})
@EnableFeignClients(basePackages = "com.study.provider.service")
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
