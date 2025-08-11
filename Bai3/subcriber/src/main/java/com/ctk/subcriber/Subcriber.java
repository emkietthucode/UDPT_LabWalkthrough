package com.ctk.subcriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Subcriber {
    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void receiveMessage(String msg) {
        System.out.println("Received message: " + msg);
    }
}