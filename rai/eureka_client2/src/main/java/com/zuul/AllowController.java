package com.zuul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
@RestController
@RequestMapping("/eureka_client")
public class AllowController {

    @RequestMapping("/zuul")
    public String zuul(){
        return "eureka_client22222222222222222 zuul";
    }
}
