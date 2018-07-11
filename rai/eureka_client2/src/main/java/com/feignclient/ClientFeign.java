package com.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/7
 * @Time: 16:17
 */


@FeignClient(name = "client",fallback = HystrixFeignBack.class)
public interface ClientFeign {

    @GetMapping("/msg")
    String msg();



}
