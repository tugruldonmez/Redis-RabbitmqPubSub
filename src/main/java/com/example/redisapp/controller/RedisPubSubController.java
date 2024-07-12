package com.example.redisapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisPubSubController {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RedisPubSubController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/publish/{channel}")
    public void publishMessage(@PathVariable String channel, @RequestBody String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
