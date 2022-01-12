package com.bigblue.scheduler.domain.json;

import lombok.Data;

import java.util.List;

@Data
public class JsonContent {

    private List<JsonEdge> edges;
    private List<JsonNode> nodes;
    private String jobId;
}
