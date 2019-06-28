package com.zhuzhixu.adminproject.service;

import com.zhuzhixu.adminproject.dao.ProductMapper;
import com.zhuzhixu.adminproject.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    List<ProductEntity> getAllProducts(){
        return productMapper.getAllEntity();
    }

    ProductEntity getProductEntityById(long id){
        return productMapper.getProductEnyityById(id);
    }

    void updateProductEntity(Long id , String name, String description, String category, int amount, Date date){
        productMapper.updateProduct(id, name, description, category, amount, date);
    }
}
