package com.rabbitmq;

import org.springframework.stereotype.Component;

/**
 * @Created with IntelliJ IDEA.
 * @author: XIAOPING JIANG
 * @Date: 2018/5/8
 * @Time: 11:59
 */
@Component
public class Sender {

 /*   @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg = "hello rabbitmq:"+new Date();
        System.out.println("Sender:"+msg);
        this.rabbitTemplate.convertAndSend("hello", msg);
    }
    */
}
