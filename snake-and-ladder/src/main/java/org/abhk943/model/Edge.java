package org.abhk943.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
    private Long startPoint;
    private Long endPoint;

    public Edge(Long startPoint, Long endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}
