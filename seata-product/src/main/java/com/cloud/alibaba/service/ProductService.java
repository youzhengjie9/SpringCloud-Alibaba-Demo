package com.cloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.alibaba.entity.Product;

public interface ProductService extends IService<Product> {

    boolean buyProduct(Long productId);

}
