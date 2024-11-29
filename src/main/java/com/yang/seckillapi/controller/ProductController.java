package com.yang.seckillapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yang.seckillapi.pojo.Product;
import com.yang.seckillapi.pojo.PageBean;
import com.yang.seckillapi.pojo.Result;
import com.yang.seckillapi.service.ProductService;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    //新增商品
    @PostMapping("/add")
    public Result add(@RequestBody @Validated Product product) {
        System.out.println(product);
        productService.add(product);
        return Result.success();
    }

    //修改商品
    @PutMapping("/update")
    public Result update(@RequestBody @Validated Product product) {
        productService.update(product);
        return Result.success();
    }

    //获取商品详情
    @GetMapping("/detail")
    public Result<Product> detail(@RequestParam Long id) {
        Product product = productService.findById(id);
        return Result.success(product);
    }

    //查找商品,分页,模糊查询,筛选价格
    @GetMapping("/search")
    public Result<PageBean<Product>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) String maxPrice
    ) {
       PageBean<Product> pb =  productService.list(pageNum, pageSize, keyword, minPrice, maxPrice); // Pass keyword to service
       return Result.success(pb);
    }
    
}
