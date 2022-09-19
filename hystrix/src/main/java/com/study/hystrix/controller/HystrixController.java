package com.study.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Date: 2022-09-16 星期五
 * Time: 9:49
 * Author: Dily_Su
 * Remark: RestTemplate 远程调用熔断
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {


    @Autowired
    private RestTemplate restTemplate;


    /**
     * 熔断触发降级
     * @param num 参数
     * @return 字符串
     */
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),  // 默认20, 最小产生5次请求
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), // 熔断时间, 该时间内快速失败
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), // 10s内失败率达到50%触发熔断
            }, // 10s 内最少 5 个请求, 如果失败率大于 50% 则触发熔断
            fallbackMethod = "fallback"
    )  // 服务调用失败时，触发熔断进行降级
    @GetMapping("/test")
    public String test(@RequestParam Integer num) {
        if (num % 2 == 0) {
            return "访问正常";
        }

        List<?> list = restTemplate.getForObject("http://localhost:7070/product/list", List.class);
        assert list != null;
        return list.toString();
    }

    /**
     * 熔断时触发降级
     *
     * @param num 参数
     * @return 字符串
     */
    private String fallback(Integer num) {
        // 降级操作
        return "系统繁忙";
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            },
            fallbackMethod = "timeout"
    )
    @GetMapping("/timeout")
    public String timeoutTest(){
        return restTemplate.getForObject("http://localhost:7070/product/list", String.class);
    }

    /**
     * 超时时触发降级
     *
     * @return 字符串
     */
    private String timeout() {
        // 降级操作
        return "请求超时";
    }
}
