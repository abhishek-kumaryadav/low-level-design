package org.abhk943.services;

import java.util.Random;

public class Dice implements DiceInterface {

    private static final Long diceSize = 6L;
    public Long roll() {
        Random random = new Random();
        int randomNumber = random.nextInt((int) (diceSize - 1)) + 1;
        return (long) randomNumber;
    }
}
