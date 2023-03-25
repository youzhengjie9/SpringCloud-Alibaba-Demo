package com.cloud.alibaba.feign;

import com.cloud.alibaba.config.FeignConfig;
import com.cloud.alibaba.dto.Order;
import com.cloud.alibaba.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * seata-order服务上的OrderController的远程调用feign接口
 *
 * @author youzhengjie
 * @date 2023/03/25 11:51:30
 */
//@FeignClient的value是被调用方的spring.application.name
//@FeignClient的path是被调用接口的类上的@RequestMapping的path,如果被调用接口的类上没有@RequestMapping则可以不用写这个属性
@FeignClient(value = "seata-order",path = "/order",configuration = FeignConfig.class)
public interface OrderFeignService {

    @PostMapping(path = "/generateOrder")
    public ResponseResult<String> generateOrder(@RequestBody Order order);

}
