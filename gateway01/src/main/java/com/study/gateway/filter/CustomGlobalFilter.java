package com.study.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;

/**
 * Date: 2022-06-28 星期二
 * Time: 14:55
 * Author: Dily_Su
 * Remark: 自定义全局过滤器
 * 统一鉴权
 */
//@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 过滤器业务逻辑
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("自定义全局过滤器被执行");

        // 获取请求参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 业务处理
        if (token == null){
            ServerHttpResponse response = exchange.getResponse();
            // 响应类型
            response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            // 响应状态， 401 代表没权限
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 响应内容
            String message = "{\"message\":" + HttpStatus.UNAUTHORIZED.getReasonPhrase() + "\"}";
            DataBuffer buffer = response.bufferFactory().wrap(message.getBytes(StandardCharsets.UTF_8));
            // 请求结束
            return response.writeWith(Mono.just(buffer));
        }
        // 使用 token 进行身份验证
        System.out.println("验证通过");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
