package com.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关应用程序
 *
 * @author youzhengjie
 * @date 2023/03/20 18:58:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelGatewayApplication.class,args);
    }
}