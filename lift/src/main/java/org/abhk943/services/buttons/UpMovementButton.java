package org.abhk943.services.buttons;

import org.abhk943.models.Lift;
import org.abhk943.models.enums.DirectionType;
import org.abhk943.services.LiftRepository;
import org.abhk943.services.NotificationObserver;
import org.abhk943.services.interfaces.MovementButtonInterface;
import org.abhk943.services.interfaces.NotificationPublisherAbstractClass;

import java.util.ArrayList;

public class UpMovementButton extends NotificationPublisherAbstractClass implements MovementButtonInterface {

    public UpMovementButton(){
        this.liftRepository = LiftRepository.getInstance();
        this.observationInterfaceList = new ArrayList<>();
        this.observationInterfaceList.add(new NotificationObserver());
    }

    @Override public void onPress(Integer floor) throws InterruptedException {
        Lift lift = this.liftRepository.getLift();
        if(!lift.getUpList().contains(floor))
            lift.getUpList().add(floor);
        if(lift.getDirectionType().equals(DirectionType.STATIONARY))
            lift.setDirectionType(DirectionType.UP);
        Thread.sleep(5000);
        notifyObservers();
    }
}
