package com.bigblue.scheduler.service;

import com.bigblue.scheduler.base.enums.TaskStatus;
import com.bigblue.scheduler.domain.NodeTask;
import com.bigblue.scheduler.domain.json.JsonContent;

import java.util.Map;

/**
 * 任务调度器
 */
public interface TaskScheduler {

    String parseTaskAndSchedule(JsonContent jsonContent);

    //组装Tasks
    String startNodeTasks(String jobId, Map<String, NodeTask> nodeTasks, TaskListener statusListener) throws RuntimeException;

    //开始调度
    void startTaskSchedule(String taskId);

    //取消调度
    void cancelTaskScheduler(String taskId, TaskStatus taskStatus);

}
