package com.zhuzhixu.adminproject.dao;


import com.zhuzhixu.adminproject.entity.ProductEntity;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface ProductMapper {
    @Select("select * from t_product")
    List<ProductEntity> getAllEntity();

    @Select("select * form t_product where id=#{id}")
    ProductEntity getProductEnyityById(long id);

    @Update("update t_product set name=#{name}, description=#{description}, category=#{category} where id = #{id}")
    void updateProduct(long id, String name, String description, String category, int amount, Date time);
}
