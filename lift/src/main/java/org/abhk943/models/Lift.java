package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;
import org.abhk943.models.enums.DirectionType;

import java.util.List;

@Getter
@Setter
public class Lift {
    private Integer currentFloor;
    private List<Integer> upList;
    private List<Integer> downList;
    private DirectionType directionType;
}
