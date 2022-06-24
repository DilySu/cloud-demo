package com.study.provider.controller;

import com.study.provider.entity.Order;
import com.study.provider.entity.Production;
import com.study.provider.service.OrderService;
import com.study.provider.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProductionService productionService;

    @RequestMapping("/order")
    public Order order(){
        return orderService.getList();
    }
    @RequestMapping("/createProduct")
    public Map createProduct(@RequestBody  Map o){
        return orderService.createProduct(o);
    }

    @RequestMapping("/selectProduct")
    public Object selectByProduct(){
        return productionService.selectByProduct(new Production(1,"ddd",2,11D));
    }
}
