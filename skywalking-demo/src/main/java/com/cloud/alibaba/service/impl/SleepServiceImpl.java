package com.cloud.alibaba.service.impl;

import com.cloud.alibaba.service.SleepService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SleepServiceImpl implements SleepService {
    @Override
    //将方法加入追踪链路，如果一个业务方法想在ui界面的跟踪链路上显示出来，只需要在service实现类的方法上加上@Trace注解即可
    @Trace
    @Tags({
            //“param”可以随便写，arg[n]是固定写法，n从0开始，代表方法的参数下标（代表Long second）
            @Tag(key = "param",value = "arg[0]"),
            //“sleep”可以随便写，returnedObj是固定写法，代表获取该方法的返回值
            @Tag(key = "sleep",value = "returnedObj")
    })
    public String sleep(Long second) {
        try {
            //睡眠
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return UUID.randomUUID().toString();
    }
}
