package com.bigblue.scheduler.service;

import java.util.Map;

public interface INodeTask {

    Map<String, Object> doTask() throws Exception;
}
