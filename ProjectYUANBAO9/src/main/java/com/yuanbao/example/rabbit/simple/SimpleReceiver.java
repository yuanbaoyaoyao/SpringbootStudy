package com.yuanbao.example.rabbit.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;

public class SimpleReceiver {

    private static final Logger lOGGER = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(String in){
        lOGGER.info(" [x] Received '{}'",in);
    }

}
