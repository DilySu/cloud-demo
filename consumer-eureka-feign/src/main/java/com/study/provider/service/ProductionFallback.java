package com.study.provider.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2022-09-19 星期一
 * Time: 14:36
 * Author: Dily_Su
 * Remark: ProductionService 的熔断降级操作
 */
@Component
public class ProductionFallback implements ProductionService {
    @Override
    public Object getProduction(Integer id) {
        return "请求失败";
    }

    @Override
    public Map createProduction(Object production) {
        return new HashMap<>();
    }

    @Override
    public Object selectByProduct(Object product) {
        return "请求失败";
    }
}
