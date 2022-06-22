package com.study.provider.service;

import com.study.provider.entity.Production;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:17
 * Author: Dily_Su
 * Remark:
 */
@Service
public class ProductService {

    public List<Production> getList() {
        return Arrays.asList(
                new Production(1, "Mac pro 2022", 2, 10000.0),
                new Production(1, "Mac air 2022", 2, 10000.0),
                new Production(1, "Mac mini 2022", 2, 10000.0)
        );
    }

    public Production getProduction(Integer id) {
        return new Production(id, "Mac mini 2022", 2, 10000.0);
    }
}
