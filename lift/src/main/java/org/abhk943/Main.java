package org.abhk943;

import org.abhk943.exceptions.InvalidPressException;
import org.abhk943.models.Lift;
import org.abhk943.models.enums.ButtonType;
import org.abhk943.services.LiftFascade;

public class Main {
    public static void main(String[] args) throws InvalidPressException, InterruptedException {

        LiftFascade liftFascade = new LiftFascade();
        liftFascade.pressMovementButton(ButtonType.UP, 5);
        liftFascade.pressOperationButton(ButtonType.CLOSE_BUTTON);
        System.out.println("");
    }
}