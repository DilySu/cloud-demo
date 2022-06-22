package com.study.provider.controller;

import com.study.provider.entity.Order;
import com.study.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:20
 * Author: Dily_Su
 * Remark:
 */
@RestController
public class ProductController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public Order order(){
        return orderService.getList();
    }
}
