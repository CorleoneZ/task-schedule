package com.bigblue.scheduler.service;

import com.bigblue.scheduler.domain.ParentTask;

import java.util.Map;

public interface TaskListener {

    void process(String TaskId, ParentTask parentTask, Map<String,Object> result);

    void onFail(String taskId, ParentTask parentTask, Throwable t);
}
