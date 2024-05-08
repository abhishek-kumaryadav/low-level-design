package org.abhk943.services;

import org.abhk943.models.Lift;
import org.abhk943.models.enums.DirectionType;

import java.util.ArrayList;
import java.util.Objects;

public class LiftRepository {

    private static LiftRepository liftRepository;

    private Lift lift;

    private LiftRepository (){
        this.lift = new Lift();
        this.lift.setDirectionType(DirectionType.STATIONARY);
        this.lift.setDownList(new ArrayList<>());
        this.lift.setUpList((new ArrayList<>()));
        this.lift.setCurrentFloor(1);
    }

    public static LiftRepository getInstance(){
        if(Objects.isNull(liftRepository)){
            liftRepository = new LiftRepository();
        }
        return liftRepository;
    }

    public Lift getLift(){
        return lift;
    }
}
