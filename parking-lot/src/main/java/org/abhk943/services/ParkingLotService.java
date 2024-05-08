package org.abhk943.services;

import org.abhk943.exceptions.ParkingLotException;
import org.abhk943.model.*;
import org.abhk943.repositories.FloorRepository;
import org.abhk943.repositories.LotRepository;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParkingLotService implements ParkingLotInterface {

    private ParkingLot parkingLot;

    private FloorRepository floorRepository;
    private LotRepository lotRepository;

    @Override public boolean checkIsFull(VehicleType vehicleType) {
        return parkingLot.getFloorList().stream().map(Floor::getLotList).flatMap(List::stream).filter(
                lot -> (lot.getVehicleType().equals(vehicleType) || vehicleType.equals(VehicleType.TWO_WHEELER))).map(
                Lot::getIsFilled).collect(Collectors.toList()).contains(false);
    }

    @Override public MutablePair<Long, Long> getLotAndFloor(VehicleType vehicleType) throws ParkingLotException {
        Optional<Lot> freeLot = parkingLot.getFloorList().stream().map(Floor::getLotList).flatMap(List::stream).filter(
                lot -> (lot.getVehicleType().equals(vehicleType) || vehicleType.equals(VehicleType.TWO_WHEELER)) && lot.getIsFilled().equals(false)).collect(
                Collectors.toList()).stream().findFirst();
        if(!freeLot.isPresent())
            throw new ParkingLotException("Parking lot is not empty");

        return MutablePair.of(freeLot.get().getId(), freeLot.get().getFloorId());
    }

    @Override public void enterVehicle(Vehicle vehicle, Lot lot) throws ParkingLotException {
        if(lot.getIsFilled())
            throw new ParkingLotException("Lot is already filled");
        lot.setIsFilled(true);
        lotRepository.addVehicle(lot.getId(), vehicle.getNumber());
    }

    @Override public void exitVehicle(Vehicle vehicle) {
        lotRepository.freeLot(vehicle);
    }

    public void loadParkingLot(){
        List<Long> floorIds = floorRepository.getFloorIds();
        Map<Long, List<Lot>> floorIdToLotListMap = floorIds.stream().collect(Collectors.toMap(
                Function.identity(), floorId -> lotRepository.getLotsByFloor(floorId)));
        parkingLot.setFloorList(getFloorObject(floorIdToLotListMap));
    }

    private List<Floor> getFloorObject(Map<Long, List<Lot>> floorIdToLotListMap) {
        return floorIdToLotListMap.keySet().stream().map(floorId -> {
            Floor floor = new Floor();
            floor.setFloorId(floorId);
            floor.setLotList(floorIdToLotListMap.get(floorId));
            return floor;
        }).collect(Collectors.toList());
    }

    public void disableFloor(Long floorId){
        floorRepository.remove(floorId);
    }

    public void enableFloor(Long floorId){
        floorRepository.add(floorId);
    }
}
