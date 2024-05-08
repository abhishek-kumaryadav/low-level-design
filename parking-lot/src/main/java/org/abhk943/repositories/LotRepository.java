package org.abhk943.repositories;

import org.abhk943.model.Lot;
import org.abhk943.model.Vehicle;

import java.util.List;
import java.util.Map;

public class LotRepository {
    private Map<String, Long> vehicleNumberToLotIdMap;
    private Map<Long, List<Lot>> floorIdToLotIdListMap;

    public void addVehicle(Long lotId, String vehicleNumber){

    }

    public void freeLot(Vehicle vehicle) {
        vehicleNumberToLotIdMap.remove(vehicle.getNumber());
    }

    public List<Lot> getLotsByFloor(Long floorId){
        return floorIdToLotIdListMap.get(floorId);
    }
}
