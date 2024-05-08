package org.abhk943.services;

import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.services.interfaces.LocationObserver;

import java.util.ArrayList;
import java.util.List;

public class LocationSharing implements LocationObserver {

    @Override public void notify(User user, Location location) {
        // get emergency contacts for user
        List<Long> phoneNUmbers = new ArrayList<>();
        phoneNUmbers.add(1L);
        phoneNUmbers.add(2L);

        for(Long number : phoneNUmbers)
            System.out.println("Sending location to phoneNumber: " + number +
                               ", Location: " + location.getX()+ ". " + location.getY());
    }
}
