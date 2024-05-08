package org.abhk943.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Lot {
    private Long id;
    private Boolean isFilled;
    private VehicleType vehicleType;
    private Long floorId;
}
