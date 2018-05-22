package com.stream.dao.sinksender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

@EnableBinding(value = {SendToSender.SendToBinderReverse.class})
public class SendToSender {




        @Bean
       // @InboundChannelAdapter(value = SendToBinderReverse.OUTPUT, poller = @Poller(fixedDelay = "3000"))  //定时发送信息
       // @InboundChannelAdapter(value = SendToBinderReverse.OUTPUT)  //定时发送信息
        public MessageSource<String> sendToTest() {

            return () -> new GenericMessage<>("{\"no\":\"abc\",\"status\":1}");

        }



        @StreamListener(SendToBinderReverse.INPUT) // 监听input通道

        public void receiveFromInput(String car) {
            System.out.println(" 生产者SendToSender Received: " + car.toString());

        }



        public interface SendToBinderReverse {

            String OUTPUT = "sendtoInput";// 消费者绑定的监听通道为sendtoInput，所以生产者的output通道指定为sendtoInput

            String INPUT = "sendtoOutput";// 消费者反馈信息的通道为sendtoOutput，所以生产者的input通道指定为sendtoOutput





            @Output(OUTPUT)
            SubscribableChannel output();


            @Input(INPUT)
            SubscribableChannel input();








            String INPUTO="INPUTOINPUTO";
            @Output(INPUTO)
            SubscribableChannel inputoinputo();


            String INPUTO2="INPUTOINPUTO2";
            @Input(INPUTO2)
            SubscribableChannel INPUTOINPUTO2();

        }


    @StreamListener(SendToBinderReverse.INPUTO2) // 监听消费者返回来的消息

    public void inputoinputo2(String mesag) {
        System.out.println(" 消费者接受到消息返回过来的.: " + mesag.toString());

    }


}
