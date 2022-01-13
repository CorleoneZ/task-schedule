package com.bigblue.scheduler.domain;

import com.bigblue.scheduler.base.enums.TaskStatus;
import com.bigblue.scheduler.service.TaskListener;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Data
@Builder
public class ParentTask {

    private String id;
    private Map<String, NodeTask> nodeTasks;
    //成功结束的nodeTask个数
    private AtomicInteger nodeTaskSuccCnt;
    private volatile TaskStatus parentTaskStatus;
    private TaskListener taskListener;

    /**
     * 计算运行度
     * @return
     */
    public double getProgress() {
        double fraction = (double) nodeTaskSuccCnt.get() / nodeTasks.size();
        return (double) Math.round(fraction * 100) / 100;
    }

    /**
     * 获取各task状态
     */
    public List<TaskResult> getTasksStatus() {
        Collection<NodeTask> values = nodeTasks.values();
        return values.stream().map(nodeTask ->
                new TaskResult(nodeTask.getTaskId(), nodeTask.getTaskStatus(), nodeTask.getTakeTime()))
                .collect(Collectors.toList());
    }

    public NodeTask getNodeTask(String nodeTaskId) {
        return nodeTasks.get(nodeTaskId);
    }

    public int nodeTaskSuccess() {
        return nodeTaskSuccCnt.addAndGet(1);
    }

    public void nodeTaskFail() {
        this.parentTaskStatus = TaskStatus.fail;
    }

    public boolean isFail() {
        return parentTaskStatus == TaskStatus.fail;
    }

    //Task是否失败或完成
    public boolean isFailOrFinish() {
        return nodeTaskSuccCnt.get() == nodeTasks.size() || parentTaskStatus == TaskStatus.fail;
    }

}
