package com.study.provider.controller;

import com.study.provider.entity.Production;
import com.study.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:20
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public List<Production> getProductList() {
        return productService.getList();
    }

    @RequestMapping("/getProduction")
    public Production getProduction(@RequestParam Integer id) {
        return productService.getProduction(id);
    }
}
