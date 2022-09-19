package com.study.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Date: 2022-06-22 星期三
 * Time: 15:06
 * Author: Dily_Su
 * Remark:
 */
@FeignClient(value = "provider", fallback = ProductionFallback.class)   // fallback 用于熔断
public interface ProductionService {
    @RequestMapping("/product/getProduction")
    Object getProduction(@RequestParam Integer id);
//    Object getProduction(Integer id);

    @RequestMapping("/product/create")
    Map createProduction(Object production);

    @GetMapping("/product/selectProduct")
    Object selectByProduct(Object product);
}
