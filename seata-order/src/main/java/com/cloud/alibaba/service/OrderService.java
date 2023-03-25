package com.cloud.alibaba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.alibaba.entity.Order;

public interface OrderService extends IService<Order> {

    boolean generateOrder(Order order);

}
