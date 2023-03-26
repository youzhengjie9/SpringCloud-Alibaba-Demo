package com.cloud.alibaba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.alibaba.dto.Order;
import com.cloud.alibaba.entity.Product;
import com.cloud.alibaba.feign.OrderFeignService;
import com.cloud.alibaba.mapper.ProductMapper;
import com.cloud.alibaba.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderFeignService orderFeignService;

    /**
     * 购买产品（---分布式事务---）
     *
     * @param productId 产品id
     * @return boolean
     */
    @Override
    @GlobalTransactional(rollbackFor = Exception.class) //开启seata分布式事务
    public boolean buyProduct(Long productId) {
        try {
            //product数量-1
            productMapper.descNumber(productId,1);
            //远程调用order的feign接口（生成订单）<<<----分布式事务
            Order order = Order.builder()
                    .productId(productId)
                    .count(1)
                    .build();
            orderFeignService.generateOrder(order);
            logger.info("购买成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("购买失败,进行分布式事务回滚");
            throw new RuntimeException("购买失败,进行分布式事务回滚");
        }

    }
}
