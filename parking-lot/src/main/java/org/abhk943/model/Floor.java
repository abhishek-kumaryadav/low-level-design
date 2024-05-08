package org.abhk943.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor {
    Long floorId;
    List<Lot> lotList;
}
