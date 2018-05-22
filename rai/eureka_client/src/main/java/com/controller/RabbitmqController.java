package com.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitmqController {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @GetMapping("/send")
    public void  send(){
         amqpTemplate.convertAndSend("client_rabbitmq", "rabbitmq 发生消息端发送的一条消息" + new Date().toString() + "");
    }


    @GetMapping("/send1")
    public void  send1(){
        amqpTemplate.convertAndSend("myMessage","Order", "Orderrabbitmq 发生消息端发送的一条消息" + new Date().toString() + "");
    }

    @GetMapping("/send2")
    public void  send2(){
        amqpTemplate.convertAndSend("myMessage","School", "Orderrabbitmq 发生消息端发送的一条消息" + new Date().toString() + "");
    }





   @Autowired StreamRabbitmqClient streamRabbitmqClient;
    @GetMapping("/send3")
    public void  send3(){
        System.out.println("发送消息"+new Date());
        streamRabbitmqClient.ouput().send(
                MessageBuilder.withPayload(
                 "StreamRabbitmqClient StreamRabbitmqClient"
                ).build()
        );
    }




}
