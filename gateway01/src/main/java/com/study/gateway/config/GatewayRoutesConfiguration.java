package com.study.gateway.config;

import com.study.gateway.filter.CustomGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2022-06-28 星期二
 * Time: 14:00
 * Author: Dily_Su
 * Remark:
 */
//@Configuration
public class GatewayRoutesConfiguration {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("test1", r -> r
                        // 断言（判断条件）
                        .path("/product/**")
                        // 自定义网关过滤器
                        .filters(f -> f.filter(new CustomGatewayFilter()))
                        // 目标 URI 路由到服务器的地址
                        .uri("lb://provider"))
                .build();
    }
}
