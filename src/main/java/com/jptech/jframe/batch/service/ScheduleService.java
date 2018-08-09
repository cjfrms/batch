package com.jptech.jframe.batch.service;

import com.jptech.jframe.batch.entity.TaskInfo;
import com.jptech.jframe.batch.job.SampleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private Scheduler scheduler;

    public void addJob(TaskInfo taskInfo) throws SchedulerException, ClassNotFoundException {
        Class clz = Class.forName(taskInfo.getJobClassName());
        JobDetail job = JobBuilder.newJob(clz).withIdentity(taskInfo.getJobName(),taskInfo.getJobGroup()).build();
        // 触发时间点
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(taskInfo.getCronExpression());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskInfo.getJobName(), taskInfo.getJobGroup())
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(job, trigger);
    }
}
