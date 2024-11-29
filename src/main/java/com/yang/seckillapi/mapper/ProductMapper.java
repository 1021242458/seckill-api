package com.yang.seckillapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yang.seckillapi.pojo.Product;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(Long id);

    @Insert("INSERT INTO product(name, title, img, detail, price, stock) " +
            "VALUES (#{name}, #{title}, #{img}, #{detail}, #{price}, #{stock})")
    void add(Product product);

    @Update("UPDATE product SET name = #{name}, title = #{title}, img = #{img}, " +
            "detail = #{detail}, price = #{price}, stock = #{stock} WHERE id = #{id}")
    void update(Product product);

    public List<Product> list(String keyword, Integer minPrice, String maxPrice);
}