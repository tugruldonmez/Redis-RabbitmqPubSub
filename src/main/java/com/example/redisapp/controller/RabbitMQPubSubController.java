package com.example.redisapp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQPubSubController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQPubSubController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publish/{queue}")
    public void publishMessage(@PathVariable String queue, @RequestBody String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }

    @RabbitListener(queues = {"yeniqueue", "myqueue", "sonqueue"})
    public void listen(String message, @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String queueName) {
        System.out.println("Received message from queue: " + queueName +"  "+"Message:"+ message );
    }
}
