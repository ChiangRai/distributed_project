package com.feignclient;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/8 0008.
 */
@Component
public class HystrixFeignBack implements ClientFeign{
    @Override
    public String msg() {
        return "HystrixFeign 客户端自己写提供";
    }
}
