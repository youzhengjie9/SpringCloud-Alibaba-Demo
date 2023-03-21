package com.cloud.alibaba.controller;

import com.cloud.alibaba.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sentinel/feign")
public class SentinelFeignController {

    @Autowired
    private StockFeignService stockFeignService;

    @GetMapping(path = "/throwEx")
    public String throwEx(){

        return stockFeignService.throwException();
    }


}
