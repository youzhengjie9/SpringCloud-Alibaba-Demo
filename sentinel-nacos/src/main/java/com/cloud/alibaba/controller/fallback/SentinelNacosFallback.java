package com.cloud.alibaba.controller.fallback;

/**
 * 抽取fallback方法单独的类
 * @author youzhengjie
 * @date 2023/03/15 11:51:06
 */
public class SentinelNacosFallback {


    /**
     * 注意1：fallback的方法名必须和fallback属性值一直。
     * 注意2：fallback方法必须要被“static”修饰！！！（当fallback方法被抽取到单独的类上时，就如当前这种情况）
     * 注意3：fallback的方法的参数要和被fallback的方法参数一致，并且在后面加上Throwable e参数
     *
     * @return {@link String}
     */
    public static String testAnnotationFallback(Integer id,Throwable e){
        return "testAnnotation-----------Fallback";
    }

    /**
     * 注意1：fallback的方法名必须和fallback属性值一直。
     * 注意2：fallback方法必须要被“static”修饰！！！（当fallback方法被抽取到单独的类上时，就如当前这种情况）
     * 注意3：fallback的方法的参数要和被fallback的方法参数一致，并且在后面加上Throwable e参数
     *
     * @return {@link String}
     */
    public static String throwExceptionFallback(Throwable e){
        return "throwException-----------Fallback服务降级";
    }

    public static String timeoutFallback(Throwable e){
        return "timeoutFallback----------Fallback服务降级";
    }



}
