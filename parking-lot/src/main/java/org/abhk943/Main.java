package org.abhk943;

import org.abhk943.repositories.FloorRepository;
import org.abhk943.services.ParkingLotService;

public class Main {
    public static void main(String[] args) {



        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.loadParkingLot();
    }
}