package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/7
 * @Time: 18:00
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String string(){
        return  "eureka_config demo"+new Date();
    }
}
