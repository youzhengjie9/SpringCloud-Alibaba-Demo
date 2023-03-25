package com.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author youzhengjie
 * @date 2023/03/23 00:17:30
 */
@EnableFeignClients //开启openfeign功能
@SpringBootApplication
@EnableDiscoveryClient
public class SeataProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataProductApplication.class,args);
    }
}