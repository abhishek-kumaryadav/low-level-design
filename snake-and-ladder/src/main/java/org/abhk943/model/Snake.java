package org.abhk943.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake extends Edge{
    public Snake(Long startPoint, Long endPoint) {
        super(startPoint, endPoint);
    }
}
