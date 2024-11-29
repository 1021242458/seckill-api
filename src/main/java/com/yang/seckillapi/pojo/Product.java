package com.yang.seckillapi.pojo;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
    // @NotNull
    private Long id; // 商品ID

    @NotEmpty
    private String name; // 商品名称

    private String title; // 商品标题

    private String img; // 商品图片URL

    private String detail; // 商品详情描述

    @NotNull
    private BigDecimal price; // 商品价格

    @NotNull
    private Integer stock; // 库存数量，-1表示无限制
}