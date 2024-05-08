package org.abhk943.services;

import org.abhk943.exceptions.InvalidPressException;
import org.abhk943.models.Lift;
import org.abhk943.models.enums.ButtonType;
import org.abhk943.models.enums.DirectionType;
import org.abhk943.services.interfaces.MovementButtonInterface;
import org.abhk943.services.interfaces.OperationButtonInterface;

import java.util.ArrayList;

public class LiftFascade {
    private LiftRepository liftRepository;

    public LiftFascade(){
        this.liftRepository = LiftRepository.getInstance();
    }

    public void pressMovementButton(ButtonType buttonType, Integer floor)
            throws InvalidPressException, InterruptedException {
        MovementButtonInterface button = ButtonFactory.getMovementButton(buttonType);
        button.onPress(floor);
    }

    public void pressOperationButton(ButtonType buttonType) throws InvalidPressException {
        OperationButtonInterface button = ButtonFactory.getOperationButton(buttonType);
        button.onPress();
    }
}
