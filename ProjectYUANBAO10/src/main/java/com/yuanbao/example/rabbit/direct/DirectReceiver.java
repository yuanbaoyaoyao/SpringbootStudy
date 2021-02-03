package com.yuanbao.example.rabbit.direct;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


public class DirectReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectReceiver.class);

    @RabbitListener(queues = "#{directQueue1.name}")
    public void receive1(String in){
        receive(in,1);
    }
    private void receive(String in,int receiver){
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [x] Received '{}'",receiver,in);
        doWork(in);
        watch.stop();
        LOGGER.info("instance {} [x] Done in {}s",receiver,watch.getTotalTimeSeconds());
    }
    private void doWork(String in){
        for(char ch:in.toCharArray()){
            if(ch=='.'){
                ThreadUtil.sleep(1000);
            }
        }
    }
}
