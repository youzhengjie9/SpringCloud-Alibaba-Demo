package com.cloud.alibaba.controller.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 抽取block方法单独的类
 * @author youzhengjie
 * @date 2023/03/15 11:55:52
 */
public class SentinelNacosBlock {

    /**
     * 注意1：block方法必须要和blockHandler的值一致。
     * 注意2：block方法必须要被“static”修饰！！！（当block方法被抽取到单独的类上时，就如当前这种情况）
     * 注意3：block的方法的参数要和被block的方法参数一致，并且在后面加上BlockException e参数
     * @return {@link String}
     */
    public static String testAnnotationBlock(Integer id, BlockException e){
        return "testAnnotation-----------block";
    }


}
