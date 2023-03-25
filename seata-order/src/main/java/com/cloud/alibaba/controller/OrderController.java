package com.cloud.alibaba.controller;

import com.cloud.alibaba.entity.Order;
import com.cloud.alibaba.service.OrderService;
import com.cloud.alibaba.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    @Qualifier("orderServiceImpl")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 生成订单
     *
     * @param order 订单
     * @return {@link ResponseResult}<{@link String}>
     */
    @PostMapping(path = "/generateOrder")
    public ResponseResult<String> generateOrder(@RequestBody Order order){
        int i = 10 / 0 ;
        return orderService.generateOrder(order)?
                ResponseResult.ok("生成订单成功"):ResponseResult.fail("生成订单失败");
    }

}
