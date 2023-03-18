package com.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.alibaba.controller.block.SentinelNacosBlock;
import com.cloud.alibaba.controller.fallback.SentinelNacosFallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sentinel/nacos")
public class SentinelNacosController {

    /**
     * 受Sentinel保护的接口
     * @return {@link String}
     */
    @GetMapping(path = "/testAnnotation/{id}")
    @SentinelResource(value = "testAnnotation",
            fallback = "testAnnotationFallback",
            fallbackClass = SentinelNacosFallback.class,
            blockHandler = "testAnnotationBlock",
            blockHandlerClass = SentinelNacosBlock.class)
    public String testAnnotation(@PathVariable("id") Integer id){
        return "testAnnotation---"+id;
    }

    @GetMapping(path = "/throwException")
    @SentinelResource(value = "throwException",
            fallback = "throwExceptionFallback",
            fallbackClass = SentinelNacosFallback.class)
    public String throwException(){
        //模拟出现异常,sentinel对异常作“服务降级fallback”处理
        int i = 10/0;
        return "throwException";
    }


}
