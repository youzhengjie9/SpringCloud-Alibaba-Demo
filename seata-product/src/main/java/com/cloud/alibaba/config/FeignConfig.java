package com.cloud.alibaba.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * openfeign配置
 *
 * @author youzhengjie
 * @date 2023/03/23 17:31:42
 */
//注意：此处配置@Configuration注解就会全局生效，如果想指定对应微服务生效，就不能配置
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
