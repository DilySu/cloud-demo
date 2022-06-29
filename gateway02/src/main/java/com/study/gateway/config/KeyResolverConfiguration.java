package com.study.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Date: 2022-06-28 星期二
 * Time: 16:45
 * Author: Dily_Su
 * Remark: 限流规则
 * 下面 Bean 只能有一个
 */
@Configuration
public class KeyResolverConfiguration {
    /**
     * URI 限流
     *
     * @return
     */
//    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }

    /**
     * 参数 限流
     *
     * @return
     */
//    @Bean
    public KeyResolver parameterKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("id")));
    }

    /**
     * IP 限流
     *
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress().getHostName()));
    }
}
