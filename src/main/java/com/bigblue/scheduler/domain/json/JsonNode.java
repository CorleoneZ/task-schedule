package com.bigblue.scheduler.domain.json;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JsonNode {
    private String id;
    private String type;
    private Map<String,Object> props;
    private String shape;
    private List<Map<String,Object>> inputs;
    private List<Map<String,Object>> outputs;
}
