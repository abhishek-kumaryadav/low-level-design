package org.abhk943.services;

import org.abhk943.models.Lift;
import org.abhk943.models.enums.DirectionType;
import org.abhk943.services.buttons.DownMovementButton;
import org.abhk943.services.interfaces.ObservationInterface;

import java.util.Objects;
import java.util.Optional;

public class NotificationObserver implements ObservationInterface {
    private LiftRepository liftRepository;
    public NotificationObserver(){
        this.liftRepository = LiftRepository.getInstance();
    }
    @Override public void notifyLift() {
        Lift lift = this.liftRepository.getLift();
        if(lift.getDirectionType().equals(DirectionType.UP)){
            Optional<Integer> nextFloor = lift.getUpList().stream().filter(
                    floor -> floor> lift.getCurrentFloor()).sorted().findFirst();
            if(nextFloor.isPresent()){
                System.out.println("Moved to floor " + nextFloor);
                lift.getUpList().remove(nextFloor.get());
                lift.setCurrentFloor(nextFloor.get());
            } else if (!lift.getDownList().isEmpty()) {
                System.out.println("Changing direction from up to down at floor " + lift.getCurrentFloor());
                lift.setDirectionType(DirectionType.DOWN);
                notifyLift();
            } else {
                lift.setDirectionType(DirectionType.STATIONARY);
                System.out.println("Stationary at floor " + lift.getCurrentFloor());
            }
        } else if (Objects.equals(lift.getDirectionType(), DirectionType.DOWN)) {
            Optional<Integer> nextFloor = lift.getUpList().stream().filter(
                    floor -> floor < lift.getCurrentFloor()).sorted().findFirst();
            if(nextFloor.isPresent()){
                lift.getDownList().remove(nextFloor.get());
                System.out.println("Moved to floor " + nextFloor);
                lift.setCurrentFloor(nextFloor.get());
            } else if (!lift.getUpList().isEmpty()) {
                System.out.println("Changing direction from down to up at floor " + lift.getCurrentFloor());
                lift.setDirectionType(DirectionType.UP);
                notifyLift();
            }
            else{
                lift.setDirectionType(DirectionType.STATIONARY);
                System.out.println("Stationary at floor " + lift.getCurrentFloor());
            }
        } else {
            lift.setDirectionType(DirectionType.UP);
            notifyLift();
        }
    }
}
