package com.controller;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
@Component
public interface StreamRabbitmqClient {

   /*@Input("myStreamRabbitmq")
    SubscribableChannel input();*/

  @Output("myStreamRabbitmqClient")
    MessageChannel ouput();
}
