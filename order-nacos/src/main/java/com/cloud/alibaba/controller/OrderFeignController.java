package com.cloud.alibaba.controller;

import com.cloud.alibaba.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order/feign")
public class OrderFeignController {

    @Autowired
    private StockFeignService stockFeignService;

    /**
     * 根据stock-nacos的ip去调用stock-nacos的helloworld接口
     * @return {@link String}
     */
    @GetMapping(path = "/helloWorldByfeign")
    public String helloWorldByfeign(){
        return stockFeignService.helloWorld()+"====>helloWorldByfeign";
    }


}
