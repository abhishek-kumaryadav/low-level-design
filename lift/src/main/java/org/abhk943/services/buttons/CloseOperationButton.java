package org.abhk943.services.buttons;

import org.abhk943.services.LiftRepository;
import org.abhk943.services.NotificationObserver;
import org.abhk943.services.interfaces.NotificationPublisherAbstractClass;
import org.abhk943.services.interfaces.OperationButtonInterface;

import java.util.ArrayList;

public class CloseOperationButton extends NotificationPublisherAbstractClass implements OperationButtonInterface {
    public CloseOperationButton(){
        this.liftRepository = LiftRepository.getInstance();
        this.observationInterfaceList = new ArrayList<>();
        this.observationInterfaceList.add(new NotificationObserver());
    }

    @Override public void onPress() {
        notifyObservers();
    }
}
