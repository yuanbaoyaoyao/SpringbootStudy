package com.yuanbao.example.rabbit.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleRabbitConfig {
    @Bean
    public Queue hello(){
        return new Queue("simple.hello");
    }

    @Bean
    public SimpleSender simpleSender(){
         return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }
}
