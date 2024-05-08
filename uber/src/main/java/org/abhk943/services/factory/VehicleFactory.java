package org.abhk943.services.factory;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.enums.VehicleType;
import org.abhk943.services.CarService;
import org.abhk943.services.interfaces.VehicleInterface;

import java.util.Objects;

public class VehicleFactory {

    public static VehicleInterface getVehicle(VehicleType vehicleType) throws IllegalActionException {
        if (Objects.requireNonNull(vehicleType) == VehicleType.CAR) {
            return new CarService();
        }
        throw new IllegalActionException("Vehicle not present with type " + vehicleType);
    }
}
