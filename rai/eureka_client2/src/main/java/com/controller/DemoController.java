package com.controller;

import com.feignclient.ClientFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/7
 * @Time: 13:41
 */
@RestController
@Slf4j
public class DemoController {



    @GetMapping("/eureka_client2")
    public  String eureka_client(){
        return "eureka_client2";
    }


    //第二种
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    //第三种
    @Autowired
    private RestTemplate restTemplate;


    //RestTemplate 三种用法
    @GetMapping("/eureka_client2_get_eureka_client")
    public String string(){
      /*  //第一种
        RestTemplate restTemplate = new RestTemplate();
        //第一个参数 是调用的地址.第二个是返回的类型.
        String forObject = restTemplate.getForObject("http://localhost:8087/msg", String.class);
*/
        //第二种   服务的配置文件不能设置instance hostname属性 否则会报错误(本地)
      /*  RestTemplate restTemplate = new RestTemplate();
        ServiceInstance client = loadBalancerClient.choose("CLIENT");
        String host = client.getHost();
        int port = client.getPort();
        String format = String.format("http://%s:%s/msg", host, port);
        System.out.println(format);
        String forObject = restTemplate.getForObject(format, String.class);*/

        //第三种
        String forObject = restTemplate.getForObject("http://CLIENT/msg", String.class);
        return  forObject;
    }




    @Autowired
    private ClientFeign clientFeign;

    //feign 的用法
    @GetMapping("/feign")
    public String feign(){
        String msg = clientFeign.msg();
        return  msg;
    }



}
