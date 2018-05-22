package com.rabbitmq.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * Created by Administrator on 2018/5/22 0022.
 */
@EnableBinding(value = {SendToReceiver.SendToBinder.class}) // 绑定输入和输出
public class SendToReceiver {






    @StreamListener(SendToBinder.INPUT) // 监听input通道
    @SendTo(SendToBinder.OUTPUT) // 返回处理结果到output通道
    public String receiveFromInput(String String) {

        System.out.println("消费者接收到:SendToReceiver Received: " + String);

        return "消费者 我返回一些数据表示接受到了 成功了. 并且返回给生产者";

    }



    public interface SendToBinder {

        String INPUT = "sendtoInput";
        String OUTPUT = "sendtoOutput";



        @Output(OUTPUT)
        SubscribableChannel output();


        @Input(INPUT)
        SubscribableChannel input();


        String INPUTO="INPUTOINPUTO";
        @Input(INPUTO)
        SubscribableChannel inputoinputo();

        String INPUTO2="INPUTOINPUTO2";
        @Output(INPUTO2)
        SubscribableChannel INPUTOINPUTO2();


    }


    @StreamListener(SendToBinder.INPUTO) // 监听input通道
    @SendTo(SendToBinder.INPUTO2)// 返回处理结果到output通道
    public String inputoinputo(String String) {
        System.out.println("自定义inputoinputo " + String);
        return "我是消费者我已经接到消息了.并且返回消息给你(生产者).";
    }


}
