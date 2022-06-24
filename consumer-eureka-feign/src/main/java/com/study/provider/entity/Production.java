package com.study.provider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Date: 2022-06-17 星期五
 * Time: 10:15
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
public class Production implements Serializable {

    private Integer id;
    private String name;
    private Integer num;
    private Double price;

}
