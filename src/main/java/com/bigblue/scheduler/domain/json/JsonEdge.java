package com.bigblue.scheduler.domain.json;

import lombok.Data;

@Data
public class JsonEdge {

    private String id;
    private int index;
    private String source;
    private String target;
    private int sourceAnchor;
    private int targetAnchor;
}
