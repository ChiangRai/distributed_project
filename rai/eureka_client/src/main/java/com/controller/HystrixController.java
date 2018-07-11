package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

@RestController
public class HystrixController {

    @GetMapping("/Hystrix")
    public String Hystrix() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "eureka_clienteureka_clienteureka_client HystrixHystrixHystrixHystrixHystrixHystrix";
    }
}
