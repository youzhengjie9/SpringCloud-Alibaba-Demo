package com.cloud.alibaba.feign;


import com.cloud.alibaba.config.FeignConfig;
import com.cloud.alibaba.feign.fallback.StockFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用openfeign远程调用stock-nacos服务上的StockFeignController接口
 * @author youzhengjie
 * @date 2023-03-20 16:43:07
 */
//@FeignClient的value是被调用方的spring.application.name
//@FeignClient的path是被调用接口的类上的@RequestMapping的path,如果被调用接口的类上没有@RequestMapping则可以不用写这个属性
//fallback属性：指定方法fallback（服务降级）类
//指定FeignConfig配置类
@FeignClient(value = "stock-nacos",
        path = "/stock/feign",
        configuration = FeignConfig.class,
        fallback = StockFeignServiceFallback.class)
public interface StockFeignService {

    @GetMapping(path = "/throwException")
    public String throwException();


}
