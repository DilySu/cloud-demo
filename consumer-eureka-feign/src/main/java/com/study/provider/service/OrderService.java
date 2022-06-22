package com.study.provider.service;

import com.study.provider.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:17
 * Author: Dily_Su
 * Remark:
 * DiscoveryClient 实现 消费服务
 */
@Service
public class OrderService {
    @Autowired
    private ProductionService productionService;

    public Order getList() {
        return new Order(1, "202020202020", List.of(productionService.getProduction(1)));
    }

}
