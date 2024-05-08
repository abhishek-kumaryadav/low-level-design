package org.abhk943.services.interfaces;

import org.abhk943.services.LiftRepository;

import java.util.List;

public abstract class NotificationPublisherAbstractClass {

    protected List<ObservationInterface> observationInterfaceList;
    protected LiftRepository liftRepository;

    public void notifyObservers() {
        for(ObservationInterface observationInterface: this.observationInterfaceList) {
            observationInterface.notifyLift();
        }
    }
}
