package org.abhk943.services;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.models.enums.VehicleType;

import static org.junit.jupiter.api.Assertions.*;

class UberFascadeTest {

    @org.junit.jupiter.api.Test
    void matchRide() throws IllegalActionException {
        UberFascade uberFascade = UberFascade.getInstance();
        uberFascade.createUser(1L, "Abhishek");
        uberFascade.createDriver(2L, "Driver", VehicleType.CAR);

        User user = uberFascade.getUsers().get(0);
        Location location = new Location();
        Driver driver = uberFascade.matchRide(user, VehicleType.CAR, location);
        LocationPollingService locationPollingService = new LocationPollingService();
        locationPollingService.pollLocations();
        assertNotNull(user.getDriverId());
        assertNotNull(driver.getDropLocation());
        assertTrue(driver.getIsBooked());
        uberFascade.finishRide(user);
        System.out.println("DONE");
        assertNull(user.getDriverId());
        assertNull(driver.getDropLocation());
        assertFalse(driver.getIsBooked());
    }

    @org.junit.jupiter.api.Test
    void matchRideWithNoDriverPresent() throws IllegalActionException {
        UberFascade uberFascade = UberFascade.getInstance();
        uberFascade.createUser(1L, "Abhishek");
        uberFascade.createUser(2L, "Vaibhav");
        uberFascade.createDriver(2L, "Driver", VehicleType.CAR);

        User user = uberFascade.getUsers().get(0);
        User user2 = uberFascade.getUsers().get(1);
        Location location = new Location();
        Driver driver = uberFascade.matchRide(user, VehicleType.CAR, location);
        LocationPollingService locationPollingService = new LocationPollingService();
        locationPollingService.pollLocations();

        try {
            uberFascade.matchRide(user2, VehicleType.SUV, location);
        } catch (IllegalActionException e){
            assertEquals("There are no available drivers", e.getMessage());
        }
        uberFascade.finishRide(user);
    }

}