package org.abhk943.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ladder extends Edge {
    public Ladder(Long startPoint, Long endPoint){
        super(startPoint, endPoint);
    }
}
