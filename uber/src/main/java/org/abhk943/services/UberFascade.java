package org.abhk943.services;

import org.abhk943.exceptions.IllegalActionException;
import org.abhk943.models.Driver;
import org.abhk943.models.Location;
import org.abhk943.models.User;
import org.abhk943.models.enums.VehicleType;
import org.abhk943.repositories.UserRepository;
import org.abhk943.services.factory.MatchingStrategyFactory;
import org.abhk943.services.interfaces.LocationObserver;
import org.abhk943.services.interfaces.MatchingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UberFascade {
    private static UberFascade uberFascade;
    private UserRepository userRepository;
    private List<LocationObserver> locationObserverList;
    private List<Driver> driverList;

    private UberFascade(){
        this.driverList = new ArrayList<>();
        this.userRepository = UserRepository.getInstance();
        this.locationObserverList = new ArrayList<>();
        this.locationObserverList.add(new LocationSharing());
    }

    public static UberFascade getInstance(){
        if(Objects.isNull(uberFascade)){
            uberFascade = new UberFascade();
        }
        return uberFascade;
    }

    public void createUser(Long id, String name){
        this.userRepository.addUser(id, name);
    }

    public void createDriver(Long id, String name, VehicleType vehicleType) throws IllegalActionException {
        Driver driver = new Driver(id, name, vehicleType);
        driverList.add(driver);
    }

    public Driver matchRide(User user, VehicleType vehicleType, Location dropLocation) throws IllegalActionException {
        MatchingStrategy matchingStrategy = MatchingStrategyFactory.getStrategy(user.getMatchingType());
        Driver driver = matchingStrategy.matchRide(user, this.driverList, vehicleType, dropLocation);
        driver.setIsBooked(true);
        driver.setDropLocation(dropLocation);
        user.setDriverId(driver.getId());
        return driver;
    }

    public void cancelRide(User user){
        // revert payment
        unassignDriver(user);
    }

    public void finishRide(User user){
        // notification to make payment if not done yet
        unassignDriver(user);
    }

    private void unassignDriver(User user) {
        Driver driver = driverList.stream().filter(driver1 -> Objects.equals(driver1.getId(), user.getDriverId())).findAny()
                                  .get();
        driver.setIsBooked(false);
        driver.setDropLocation(null);
        user.setDriverId(null);
    }

    public void addressUpdate(User user, Location location){
        user.setLocation(location);
        for(LocationObserver locationObserver: locationObserverList){
            locationObserver.notify(user, location);
        }
    }

    public void addressUpdate(Driver driver, Location location){
        driver.setLocation(location);
    }

    public List<User> getUsers(){
        return this.userRepository.getUsers();
    }

    public List<Driver> getDrivers(){
        return this.driverList;
    }
}
