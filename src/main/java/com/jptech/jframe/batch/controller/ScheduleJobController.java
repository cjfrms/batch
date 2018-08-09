package com.jptech.jframe.batch.controller;

import com.jptech.jframe.batch.entity.TaskInfo;
import com.jptech.jframe.batch.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class ScheduleJobController {

    @Autowired
    ScheduleService scheduleService;

    @ApiOperation("添加任务")
    @PostMapping
    public ResponseEntity<TaskInfo> add(@RequestBody TaskInfo taskInfo) throws ClassNotFoundException, SchedulerException {
        scheduleService.addJob(taskInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskInfo);
    }
}
