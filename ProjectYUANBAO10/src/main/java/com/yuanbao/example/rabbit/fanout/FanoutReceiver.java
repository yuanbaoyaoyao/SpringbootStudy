package com.yuanbao.example.rabbit.fanout;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class FanoutReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receive1(String in){
        receive(in,1);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receive2(String in){
        receive(in,2);
    }

    private void receive(String in,int receiver){
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [x]");
        doWodrk(in);
        watch.stop();
        LOGGER.info("instance {} [x] Done in {}s",receiver,watch.getTotalTimeSeconds());
    }
    private void doWodrk(String in){
        for(char ch:in.toCharArray()){
            if(ch=='.'){
                ThreadUtil.sleep(1000);
            }
        }
    }
}
