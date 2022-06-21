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
    private RestTemplate restTemplate;   // 启动类 或者 Config 中 要注入bean
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired(required = false)
    private LoadBalancerClient loadBalancerClient;


    public Order getList() {
        return new Order(1, "202020202020", selectProductList("provider", "/product/list"));
//        return new Order(1, "202020202020", selectProductListWithBalancer("provider", "/product/list"));
//        return new Order(1, "202020202020", selectProductListWithBalanced("provider", "/product/list"));
    }


    /**
     * 跨服务调用
     * 无负载均衡
     *
     * @param service 服务名
     * @param api     接口
     * @return 结果
     */
    private List<?> selectProductList(String service, String api) {
        StringBuffer sb = new StringBuffer();

        // 获取服务方法
        List<String> services = discoveryClient.getServices();
        if (CollectionUtils.isEmpty(services))
            return null;

        // 根据服务名获取服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
        if (CollectionUtils.isEmpty(serviceInstances))
            return null;
        ServiceInstance si = serviceInstances.get(0);
        sb.append("http://" + si.getHost() + ":" + si.getPort() + api);

        // 返回数据
        ResponseEntity<List<?>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<?>>() {
                }
        );
        return response.getBody();
    }

    /**
     * 跨服务调用
     * 有负载均衡(默认轮询)
     *
     * @param service 服务名
     * @param api     接口
     * @return 结果
     */
    private List<?> selectProductListWithBalancer(String service, String api) {
        StringBuffer sb = new StringBuffer();

        // 根据服务名 通过负载均衡 获取服务
        ServiceInstance si = loadBalancerClient.choose(service);
        if (si == null)
            return null;
        sb.append("http://" + si.getHost() + ":" + si.getPort() + api);
        System.out.println(sb.toString());

        // 返回数据
        ResponseEntity<List<?>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<?>>() {
                }
        );
        return response.getBody();
    }

    /**
     * 跨服务调用
     * 有负载均衡 + @loadBalanced
     *
     * @param service 服务名
     * @param api     接口
     * @return 结果
     */
    private List<?> selectProductListWithBalanced(String service, String api) {

        // 返回数据
        return restTemplate.exchange(
                "http://" + service + api,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<?>>() {
                }
        ).getBody();
    }
}
