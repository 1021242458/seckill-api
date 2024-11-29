package com.yang.seckillapi.service;

import com.yang.seckillapi.pojo.Product;
import com.yang.seckillapi.pojo.PageBean;

public interface ProductService {

    public void add(Product product);

    public void update(Product product);

    public Product findById(Long id);

    //条件分页列表查询
    PageBean<Product> list(Integer pageNum, Integer pageSize, String keyword, Integer minPrice, String maxPrice);
    
}
