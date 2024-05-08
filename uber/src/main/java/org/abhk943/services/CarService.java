package org.abhk943.services;

import org.abhk943.models.enums.VehicleType;
import org.abhk943.services.interfaces.VehicleInterface;

public class CarService implements VehicleInterface {

    @Override public VehicleType getType() {
        return VehicleType.CAR;
    }
}
