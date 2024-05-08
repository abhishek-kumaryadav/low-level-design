package org.abhk943;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.models.enums.VehicleType;
import org.abhk943.services.LocationPollingService;
import org.abhk943.services.UberFascade;

public class Main {
    public static void main(String[] args) throws IllegalActionException {
        UberFascade uberFascade = UberFascade.getInstance();
        uberFascade.createUser(1L, "Abhishek");
        uberFascade.createDriver(2L, "Driver", VehicleType.CAR);

        User user = uberFascade.getUsers().get(0);
        Location location = new Location();
        Driver driver = uberFascade.matchRide(user, VehicleType.CAR, location);
        LocationPollingService locationPollingService = new LocationPollingService();
        locationPollingService.pollLocations();
        uberFascade.finishRide(user);
        System.out.println("DONE");
    }
}