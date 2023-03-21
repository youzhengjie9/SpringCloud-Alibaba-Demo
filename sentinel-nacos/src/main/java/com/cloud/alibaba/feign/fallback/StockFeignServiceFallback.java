package com.cloud.alibaba.feign.fallback;

import com.cloud.alibaba.feign.StockFeignService;
import org.springframework.stereotype.Service;

@Service
public class StockFeignServiceFallback implements StockFeignService {
    @Override
    public String throwException() {
        return "throwException----fallback服务降级";
    }
}
