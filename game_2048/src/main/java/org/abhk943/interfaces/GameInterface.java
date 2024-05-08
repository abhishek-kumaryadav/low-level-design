package org.abhk943.interfaces;

import org.abhk943.exceptions.IllegalDataException;
import org.abhk943.models.Move;

public interface GameInterface {

    void newGame(Long userId) throws IllegalDataException;
    void reset(Long userId) throws IllegalDataException;

    void move(Long userId, Move move) throws IllegalDataException;

    Long getScore(Long userId) throws IllegalDataException;

    void revert(Long userId) throws IllegalDataException;

    int[][] getState(Long userId) throws IllegalDataException;
}
