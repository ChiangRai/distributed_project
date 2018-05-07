package com;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/4
 * @Time: 14:19
 */
@FeignClient(name = "pro")
public interface ProFei {

    @GetMapping("/msg")
     String msg();
}
