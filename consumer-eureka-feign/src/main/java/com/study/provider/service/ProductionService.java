package com.study.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Date: 2022-06-22 星期三
 * Time: 15:06
 * Author: Dily_Su
 * Remark:
 */
@FeignClient("provider-eureka")
public interface ProductionService {
    @RequestMapping("/product/getProduction")
    Object getProduction(@RequestParam Integer id);

    @RequestMapping("/product/create")
    Map createProduction(Object production);
}
