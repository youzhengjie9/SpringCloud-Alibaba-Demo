package com.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/sentinel/web")
public class SentinelWebController {


    /**
     * 受保护的资源名
     */
    private static final String RESOURCE_NAME = "test";

    /**
     * 定义Sentinel限流配置
     */
    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> flowRuleList = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        //设置受保护的资源名
        flowRule.setResource(RESOURCE_NAME);
        //设置限流模式（QPS）
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置保护阈值（QPS=2，也就是说1s内如果qps>2则会被限流）
        flowRule.setCount(2);
        flowRuleList.add(flowRule);
        //把限流配置加载到Sentinel中
        FlowRuleManager.loadRules(flowRuleList);
    }


    /**
     * 受Sentinel保护的接口
     * @return {@link String}
     */
    @GetMapping(path = "/test")
    public String test(){
        Entry entry = null;
        try {
            //资源名可使用任意有业务语义的字符串，比如方法名、接口名或其它可唯一标识的字符串
            entry = SphU.entry(RESOURCE_NAME);
            //被保护的业务逻辑
            System.out.println("test---success");
            return "test---success";
        } catch (BlockException e1) {
            //资源访问被阻止、被限流或被降级都会进入这个catch块
            System.out.println("限流了。。。");
            return "限流了。。。";
        }catch (Exception e2){
            //若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(e2,entry);
        }finally {
            if(entry != null){
                entry.exit();
            }
        }
        return null;
    }

}
