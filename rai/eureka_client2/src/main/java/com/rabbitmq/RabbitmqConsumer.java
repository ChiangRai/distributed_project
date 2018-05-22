package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
@Component
public class RabbitmqConsumer {


    @RabbitListener(queuesToDeclare = @Queue("client_rabbitmq"))
    public void consumer(String message){
        System.out.println("消费者接受到了消息：client_rabbitmq "+message);
    }




    @RabbitListener(bindings = {
        @QueueBinding(
                exchange =@Exchange("myMessage"),
                key = "Order",
                value = @Queue("Order message")
        )
    })
    public void consumerOrder(String message){
        System.out.println("消费者接受到了消息：Order message "+message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    exchange =@Exchange("myMessage"),
                    key = "School",
                    value = @Queue("School message")
            )
    })
    public void consumerSchoolmessage(String message){
        System.out.println("消费者接受到了消息：School message "+message);
    }








}
