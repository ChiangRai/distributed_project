package com.zuul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@RestController
@RequestMapping("/eureka_client_no")
public class NoAllowController {

    @RequestMapping("/zuul")
    public String zuul(){
        return "eureka_client_no 2222222222222222222222 zuul";
    }
}
