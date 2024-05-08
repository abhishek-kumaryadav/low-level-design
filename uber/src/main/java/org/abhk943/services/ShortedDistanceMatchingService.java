package org.abhk943.services;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.models.enums.VehicleType;
import org.abhk943.services.interfaces.MatchingStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShortedDistanceMatchingService implements MatchingStrategy {
    @Override public Driver matchRide(User user, List<Driver> driverList, VehicleType vehicleType, Location location)
            throws IllegalActionException {
        if(Objects.isNull(driverList) || driverList.isEmpty())
            throw new IllegalActionException("There are no available drivers");
        driverList = driverList.stream().filter(driver -> !driver.getIsBooked() &&
                                                          Objects.equals(driver.getVehicle().getType(), vehicleType)).
                               collect(Collectors.toList());
        if(driverList.isEmpty())
            throw new IllegalActionException("There are no available drivers");
        return driverList.get(0);

    }
}
