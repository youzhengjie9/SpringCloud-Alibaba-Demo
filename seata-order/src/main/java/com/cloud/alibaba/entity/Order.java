package com.cloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("`order`")
@Builder
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId("id")
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableField("product_id")
    private Long productId;

    /**
     * 该订单购买商品数量
     */
    @TableField("count")
    private Integer count;

    @TableField("create_time")
    private LocalDateTime createTime;


}
