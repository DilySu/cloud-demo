package com.study.provider.controller;

import com.study.provider.entity.Production;
import com.study.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/getData/{name}/{id}")
    public String getData(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return id + name;
    }

    @RequestMapping("/create")
    public Map create(@RequestBody Production production) {
        return productService.createProduction(production) ;
    }
}
