package com.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/stock/feign")
public class StockFeignController {

    @GetMapping(path = "/helloworld")
    public String helloWorld(){
        return "helloWorld---stock-nacos--openfeign";
    }

    @GetMapping(path = "/throwException")
    public String throwException(){
        throw new RuntimeException("throwException");
    }

}
