package com.my.core.module.mq.service;

import com.my.core.module.demo.entity.Demo;
import com.sun.glass.ui.Pixels;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public class HelloSenderService {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送信息
     */
    public void send(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    /**
     * 发送demo对象
     * @param demo
    public void send(Demo demo){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", demo);
    }

    *//**
     * 发送字符串
     * @param name
     *//*
    public void send(String name){
        String context = "hello " + name + "，现在时间是：" + DateUtils.getFragmentInDays(new Date(), Pixels.Format.BYTE_ARGB);
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }*/
}
