package com.cloud.alibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author youzhengjie666
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
