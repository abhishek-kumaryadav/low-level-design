package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;
import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.enums.VehicleType;
import org.abhk943.services.factory.VehicleFactory;
import org.abhk943.services.interfaces.VehicleInterface;

@Getter
@Setter
public class Driver {
    private Long id;
    private String name;
    private VehicleInterface vehicle;
    private Location location;
    private Boolean isBooked;
    private Location dropLocation;

    public Driver(Long id, String name, VehicleType vehicleType) throws IllegalActionException {
        this.id = id;
        this.name = name;
        this.isBooked = false;
        this.vehicle = VehicleFactory.getVehicle(vehicleType);
    }
}
