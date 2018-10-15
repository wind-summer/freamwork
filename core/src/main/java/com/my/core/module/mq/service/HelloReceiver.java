package com.my.core.module.mq.service;

import com.my.core.module.demo.entity.Demo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver  : " + hello);
    }

/*    @RabbitHandler
    public void process(Demo demo){
        System.out.println("Receiver  : " + demo.getName());
    }*/
}