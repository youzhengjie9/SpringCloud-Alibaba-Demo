package com.cloud.alibaba.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用于接收SkyWalking发送的JSON数据（告警数据）
 *
 * @author youzhengjie
 * @date 2023/03/27 17:18:57
 */
@Data
public class SkywalkingAlarmDTO implements Serializable {

    private Integer scopeId;
    private String scope;
    private String name;
    private String id0;
    private String id1;
    private String ruleName;
    private String alarmMessage;
    private Long startTime;


}
