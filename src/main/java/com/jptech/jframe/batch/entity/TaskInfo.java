package com.jptech.jframe.batch.entity;

import lombok.Data;

@Data
public class TaskInfo {

    private String jobId;
    private String jobName;
    private String jobGroup;
    private String jobClassName;
    private String cronExpression;
    private String desc;
    //private String jobStatus;
}
