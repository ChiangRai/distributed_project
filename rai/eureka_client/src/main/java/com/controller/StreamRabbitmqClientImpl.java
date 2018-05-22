package com.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/5/18 0018.
 */
@Component
@EnableBinding(StreamRabbitmqClient.class)
public class StreamRabbitmqClientImpl {


/*    //接受方
  @StreamListener("myStreamRabbitmq")
    public void input(Object messages) {
        System.out.println("--input-----------------------"+messages);
    }*/

}
