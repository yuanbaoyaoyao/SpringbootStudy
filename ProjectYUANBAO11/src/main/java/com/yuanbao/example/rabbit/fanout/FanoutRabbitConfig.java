package com.yuanbao.example.rabbit.fanout;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("exchange.fanout");
    }

    @Bean
    public Queue fanoutQueue1(){
        return new AnonymousQueue();
    }

    @Bean
    public Queue fanoutQueue2(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding fanoutBinding1(FanoutExchange fanout,Queue fanoutQueue1){
        return BindingBuilder.bind(fanoutQueue1).to(fanout);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanout,Queue fanoutQueue2){
        return BindingBuilder.bind(fanoutQueue2).to(fanout);
    }

    @Bean
    public FanoutReceiver fanoutReceiver(){
        return new FanoutReceiver();
    }

    @Bean
    public FanoutSender fanoutSender(){
        return new FanoutSender();
    }
}
