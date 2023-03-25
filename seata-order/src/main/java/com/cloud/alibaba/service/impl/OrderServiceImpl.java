package com.cloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.alibaba.entity.Order;
import com.cloud.alibaba.mapper.OrderMapper;
import com.cloud.alibaba.service.OrderService;
import com.cloud.alibaba.utils.SnowId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public boolean generateOrder(Order order) {
        try {
            order.setId(SnowId.nextId())
                 .setCreateTime(LocalDateTime.now());
            this.save(order);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
