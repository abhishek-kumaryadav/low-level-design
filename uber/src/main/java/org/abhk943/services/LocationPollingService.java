package org.abhk943.services;

import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;

import java.util.List;

public class LocationPollingService {
    private UberFascade uberFascade;

    public LocationPollingService (){
        this.uberFascade = UberFascade.getInstance();
    }

    public void pollLocations(){
        List <User> userList = this.uberFascade.getUsers();
        for(User user: userList){
            Location updatedLocation = new Location();
            uberFascade.addressUpdate(user, updatedLocation);
        }

        List <Driver> driverList = this.uberFascade.getDrivers();
        for(Driver driver: driverList){
            Location updatedLocation = new Location();
            uberFascade.addressUpdate(driver, updatedLocation);
        }
    }
}
