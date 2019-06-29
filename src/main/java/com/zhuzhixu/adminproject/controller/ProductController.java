package com.zhuzhixu.adminproject.controller;

import com.zhuzhixu.adminproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String products(){
        return "products";
    }
}
