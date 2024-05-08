package org.abhk943.services.interfaces;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.models.enums.VehicleType;

import java.util.List;

public interface MatchingStrategy {
    public Driver matchRide(User user, List<Driver> driverList, VehicleType vehicleType, Location location)
            throws IllegalActionException;
}
