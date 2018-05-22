package com.rabbitmq;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


import java.util.Date;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
public interface StreamRabbitmqClient2 {





    @Output("myStreamRabbitmq123")
    MessageChannel ouput();


    @Input("myStreamRabbitmq")
    SubscribableChannel input();

    @Input("StreamRabbitmqClient")
    SubscribableChannel StreamRabbitmqClient();

}
