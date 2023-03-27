package com.cloud.alibaba.controller;

import com.cloud.alibaba.dto.SkywalkingAlarmDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Skywalking告警控制器
 *
 * @author youzhengjie
 * @date 2023/03/27 17:26:25
 */
@RestController
@RequestMapping("/alarm")
public class SkywalkingAlarmController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private JavaMailSender mailSender;

    /**
     * 发送者邮箱
     */
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 接收Skywalking服务的告警通知并发送至邮箱
     *
     * @param skywalkingAlarmDTOList 人行天桥报警dtolist
     */
    @PostMapping("/receiveAlarm")
    public void receiveAlarm(@RequestBody List<SkywalkingAlarmDTO> skywalkingAlarmDTOList) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //设置发送者邮箱
        simpleMailMessage.setFrom(from);
        //设置接收者邮箱
        simpleMailMessage.setTo(from);
        //主题
        simpleMailMessage.setSubject("Skywalking告警邮件");
        String content = getContent(skywalkingAlarmDTOList);
        //邮件内容
        simpleMailMessage.setText(content);
        //发送邮件
        mailSender.send(simpleMailMessage);
        logger.info("{}","skywalking发送告警成功");
    }

    /**
     * 获取告警内容
     *
     * @param skywalkingAlarmDTOList 人行天桥报警dtolist
     * @return {@link String}
     */
    private String getContent(List<SkywalkingAlarmDTO> skywalkingAlarmDTOList){

        StringBuilder stringBuilder = new StringBuilder();
        skywalkingAlarmDTOList.forEach((skywalkingAlarmDTO -> {
            stringBuilder
                    .append("scopeId: ").append(skywalkingAlarmDTO.getScopeId())
                    .append("\nscope: ").append(skywalkingAlarmDTO.getScope())
                    .append("\n目标 Scope的实体名称: ").append(skywalkingAlarmDTO.getName())
                    .append("\nScope 实体的ID: ").append(skywalkingAlarmDTO.getId0())
                    .append("\nid1: ").append(skywalkingAlarmDTO.getId1())
                    .append("\n告警规则名称: ").append(skywalkingAlarmDTO.getRuleName())
                    .append("\n告警消息内容: ").append(skywalkingAlarmDTO.getAlarmMessage())
                    .append("\n告警时间: ").append(skywalkingAlarmDTO.getStartTime())
                    .append("\n\n=====================\n\n");
        }));
        return stringBuilder.toString();
    }


}
