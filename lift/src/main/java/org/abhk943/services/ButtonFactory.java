package org.abhk943.services;

import org.abhk943.exceptions.InvalidPressException;
import org.abhk943.models.enums.ButtonType;
import org.abhk943.services.buttons.*;
import org.abhk943.services.interfaces.MovementButtonInterface;
import org.abhk943.services.interfaces.OperationButtonInterface;

public class ButtonFactory {

    public static MovementButtonInterface getMovementButton(ButtonType buttonType) throws InvalidPressException {
        switch (buttonType){
            case UP: return new UpMovementButton();
            case DOWN: return new DownMovementButton();
            case FLOOR: return new FloorMovementButton();
        }
        throw new InvalidPressException("Button not registered");
    }

    public static OperationButtonInterface getOperationButton(ButtonType buttonType) throws InvalidPressException {
        switch (buttonType){
            case FAN_BUTTON: return new FanOperationButton();
            case CLOSE_BUTTON: return new CloseOperationButton();
        }
        throw new InvalidPressException("Button not registered");
    }




}
