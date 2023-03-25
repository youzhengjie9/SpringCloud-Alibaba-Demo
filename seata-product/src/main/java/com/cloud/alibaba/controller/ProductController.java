package com.cloud.alibaba.controller;

import com.cloud.alibaba.service.ProductService;
import com.cloud.alibaba.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/buyProduct/{productId}")
    public ResponseResult<String> buyProduct(@PathVariable("productId") Long productId){
        return productService.buyProduct(productId)?
                ResponseResult.ok("购买成功"):ResponseResult.fail("购买失败");
    }





}
