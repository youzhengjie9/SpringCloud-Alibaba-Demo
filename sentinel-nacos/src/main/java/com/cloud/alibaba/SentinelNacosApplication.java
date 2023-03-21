package com.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients //开启openfeign功能
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelNacosApplication.class,args);
    }
}