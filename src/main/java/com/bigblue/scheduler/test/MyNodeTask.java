package com.bigblue.scheduler.test;

import com.bigblue.scheduler.domain.NodeTask;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import ch.qos.logback.classic.Logger;

@Data
public class MyNodeTask extends NodeTask {

    private long runTime;

    public MyNodeTask(long runtime, String jobId, String taskId, Set<String> dependences) {
        super(jobId, taskId, dependences);
        this.runTime = runtime;
    }

    @Override
    public Map<String, Object> doTask() throws Exception {
        Logger logger = getLogger().getLogger(getJobId());
        logger.info("do task: {}", getTaskId());
        TimeUnit.MILLISECONDS.sleep(runTime);
        if (this.getTaskId().endsWith("F")) {
            throw new RuntimeException(this.getTaskId() + " exception");
        }
        String msg = "finish MyNodeTask( " + this.getTaskId() + " )";
        Map<String, Object> result = new HashMap<>();
        result.put("msg", msg);
        return result;
    }
}
