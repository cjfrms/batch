package com.jptech.jframe.batch;

import com.jptech.jframe.batch.job.SampleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskRunner implements ApplicationRunner {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("XXXXXXXXXXXXXXXXXX:");
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        /*
        //构建job信息
        JobDetail job = JobBuilder.newJob(SampleJob.class).withIdentity("sample-job","job-group").build();
        // 触发时间点
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/20 * * * * ?");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-sample-job", "job-group")
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(job, trigger);
        */
    }
}
