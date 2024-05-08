package org.abhk943.services.buttons;

import org.abhk943.models.Lift;
import org.abhk943.models.enums.DirectionType;
import org.abhk943.services.LiftRepository;
import org.abhk943.services.NotificationObserver;
import org.abhk943.services.interfaces.MovementButtonInterface;
import org.abhk943.services.interfaces.NotificationPublisherAbstractClass;

import java.util.ArrayList;

public class DownMovementButton extends NotificationPublisherAbstractClass implements MovementButtonInterface {
    public DownMovementButton(){
        this.liftRepository = LiftRepository.getInstance();
        this.observationInterfaceList = new ArrayList<>();
        this.observationInterfaceList.add(new NotificationObserver());
    }
    @Override public void onPress(Integer floor) throws InterruptedException {
        Lift lift = this.liftRepository.getLift();
        if(!lift.getDownList().contains(floor))
            lift.getDownList().add(floor);
        if(lift.getDirectionType().equals(DirectionType.STATIONARY))
            lift.setDirectionType(DirectionType.DOWN);
        Thread.sleep(5000);
        notifyObservers();
    }

}
