package com.cloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.alibaba.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 减少number
     *
     * @param productId 产品id
     * @param number    数量
     * @return int
     */
    int descNumber(@Param("productId") Long productId,@Param("number") int number);

}
