package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/7
 * @Time: 13:41
 */
@RestController
public class RestTemplateDemoController {


    @GetMapping("/eureka_client")
    public String eureka_client(){
        return "eureka_client";
    }

    @GetMapping("/msg")
    public String msg() {
        return "this is product eureka_client' msg2";
    }
}
