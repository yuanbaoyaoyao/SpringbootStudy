package com.yuanbao.example.service;

import org.quartz.Job;

import java.util.Date;

public interface ScheduleService {
    /**
     * 通过CRON表达式调度任务
     * @param jobBeanClass
     * @param cron
     * @param data
     * @return
     */
    String scheduleJob(Class<? extends Job>jobBeanClass,String cron,String data);

    /**
     * 调度指定时间的任务
     * @param jobBeanClass
     * @param startTime
     * @param data
     * @return
     */
    String scheduleFixTimeJob(Class<? extends Job>jobBeanClass, Date startTime,String data);

    /**
     * 取消定时任务
     * @param jobName
     * @return
     */
    Boolean cancelScheduleJob(String jobName);
}
