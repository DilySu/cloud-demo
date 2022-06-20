package com.study.provider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:55
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
public class Order implements Serializable {

    private Integer id;
    private String code;
    private List<?> products;
}
