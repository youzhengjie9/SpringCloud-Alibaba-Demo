package com.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/refresh/scope")
@RefreshScope //由于@Value注解只会加载一次，所以修改nacos配置中心的文件无法更新@Value注解的值。加上@RefreshScope注解可以解决这个问题。
public class RefreshScopeController {

    @Value("${nacosconfig.username}")
    private String username;

    @GetMapping(path = "/getUsername")
    public String getUsername(){
        return username;
    }

}
