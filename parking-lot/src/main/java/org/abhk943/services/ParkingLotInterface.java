package org.abhk943.services;

import jdk.internal.util.xml.impl.Pair;
import org.abhk943.exceptions.ParkingLotException;
import org.abhk943.model.Lot;
import org.abhk943.model.Vehicle;
import org.abhk943.model.VehicleType;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.tuple.MutablePair;

public interface ParkingLotInterface {
    public boolean checkIsFull(VehicleType vehicleType);

    public MutablePair<Long, Long> getLotAndFloor(VehicleType vehicleType) throws ParkingLotException;

    public void enterVehicle(Vehicle vehicle, Lot lot) throws ParkingLotException;
    public void exitVehicle(Vehicle vehicle);
}
