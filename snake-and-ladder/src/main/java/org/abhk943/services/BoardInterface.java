package org.abhk943.services;

import org.abhk943.exceptions.IllegalInputException;
import org.abhk943.model.Edge;
import org.abhk943.model.Ladder;
import org.abhk943.model.Snake;

public interface BoardInterface {
    public void addLadder(Ladder ladder) throws IllegalInputException;
    public void addSnake(Snake ladder) throws IllegalInputException;
    public Long getFinalPosition(Long currentPosition);
}
