package com.example.redisapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("yeniqueue", false);
    }
    @Bean
    public Queue myQueue2() {
        return new Queue("myqueue", false);
    }
    @Bean
    public Queue myQueue3() {
        return new Queue("sonqueue", false);
    }
}
