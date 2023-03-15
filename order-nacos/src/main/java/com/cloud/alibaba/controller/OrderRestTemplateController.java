package com.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/order/rest")
public class OrderRestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据stock-nacos的ip去调用stock-nacos的helloworld接口
     * @return {@link String}
     */
    @GetMapping(path = "/helloWorldByIp")
    public String helloWorldByIp(){

        return restTemplate.
                getForObject("http://localhost:3301/stock/rest/helloworld", String.class)
                +"====>"+"helloWorldByIp";
    }

    /**
     * 根据stock-nacos的服务名（spring.application.name）代替其ip和端口去调用stock-nacos的helloworld接口
     * @return {@link String}
     */
    @GetMapping(path = "/helloWorldByApplicationName")
    public String helloWorldByApplicationName(){
        return restTemplate.
                getForObject("http://stock-nacos/stock/rest/helloworld", String.class)
                +"====>"+"helloWorldByApplicationName";
    }

}
