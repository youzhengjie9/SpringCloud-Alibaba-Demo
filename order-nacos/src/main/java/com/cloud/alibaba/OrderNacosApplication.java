package com.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients //开启openfeign功能
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApplication.class,args);
    }


    /**
     * restTemplate的bean
     *
     * @return {@link RestTemplate}
     */
    @Bean
    @LoadBalanced //负载均衡器。只有加了这个注解RestTemplate才能通过spring.application.name代替ip和端口去调用其他接口
    public RestTemplate restTemplate(){
         return new RestTemplate();
    }

}