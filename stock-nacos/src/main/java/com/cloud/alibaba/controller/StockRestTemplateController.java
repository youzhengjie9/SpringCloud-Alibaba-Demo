package com.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stock/rest")
public class StockRestTemplateController {

    @GetMapping(path = "/helloworld")
    public String helloWorld(){
        return "helloWorld---stock-nacos";
    }

}
