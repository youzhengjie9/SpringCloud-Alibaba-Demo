package com.cloud.alibaba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 真实开发要把实体类放到common模块
 *
 * @author youzhengjie
 * @date 2023/03/25 11:54:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productId;

    /**
     * 该订单购买商品数量
     */
    private Integer count;

    private LocalDateTime createTime;


}
