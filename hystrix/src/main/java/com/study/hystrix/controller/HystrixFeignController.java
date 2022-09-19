package com.study.hystrix.controller;

import com.netflix.hystrix.HystrixCommandProperties;
import com.study.provider.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022-09-19 星期一
 * Time: 9:58
 * Author: Dily_Su
 * Remark: Feign 远程调用熔断
 */
@RestController
@RequestMapping("/hystrixFeign")
public class HystrixFeignController {

    @Qualifier("com.study.provider.service.ProductionService")
    @Autowired
    ProductionService productService;

    @GetMapping("test")
    public String test(){
        return productService.getProduction(1).toString();
    }

}
