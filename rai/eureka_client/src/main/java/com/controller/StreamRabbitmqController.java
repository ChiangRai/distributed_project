package com.controller;

import com.stream.dao.sinksender.SendToSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
@Controller
@RequestMapping("/stream")
public class StreamRabbitmqController {


    @Autowired

    @Qualifier(SendToSender.SendToBinderReverse.INPUTO) // 通过直接注入的方式注入通道，input Sink.INPUT
    private MessageChannel inputtest;

    @RequestMapping("/send3")
    public void contextLoads() {
        System.out.println("我自己发送一条消息");
        inputtest.send(MessageBuilder.withPayload("我自己的消息#################From SinkSender").build());// 发到input2通道，无消费者

    }



}
