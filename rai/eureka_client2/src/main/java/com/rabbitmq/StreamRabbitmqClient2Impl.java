package com.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/5/18 0018.
 */
@Component
@EnableBinding(StreamRabbitmqClient2.class)
public class StreamRabbitmqClient2Impl {


    //接受方
    @StreamListener("myStreamRabbitmq123")
    public void input(Object messages) {
        System.out.println("--input-----------------------"+messages);
    }

    //接受方
    @StreamListener("myStreamRabbitmq")
    public void input123(Object messages) {
        System.out.println("--myStreamRabbitmq input-----------------------"+messages);
    }


    //接受方
    @StreamListener("StreamRabbitmqClient")
    public void input123StreamRabbitmqClient(Object messages) {
        System.out.println("--StreamRabbitmqClient input-----------------------"+messages.toString());
    }


}
