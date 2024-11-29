package com.yang.seckillapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yang.seckillapi.mapper.ProductMapper;
import com.yang.seckillapi.pojo.Product;
import com.yang.seckillapi.pojo.PageBean;
import com.yang.seckillapi.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findById(Long id) {
        Product product = productMapper.findById(id);
        return product;
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    @Override
    public void add(Product product) {
        productMapper.add(product);
    }

    @Override
    public PageBean<Product> list(Integer pageNum, Integer pageSize, String keyword, Integer minPrice, String maxPrice){
        //1.创建PageBean对象
        PageBean<Product> pb = new PageBean<>();

        //2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum,pageSize);

        //3.调用mapper
        List<Product> as = productMapper.list(keyword,minPrice,maxPrice);
        //Page中提供了方法,可以获取PageHelper分页查询后 得到的总记录条数和当前页数据
        Page<Product> p = (Page<Product>) as;

        //把数据填充到PageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
