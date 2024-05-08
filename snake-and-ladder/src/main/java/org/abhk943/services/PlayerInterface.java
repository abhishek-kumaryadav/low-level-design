package org.abhk943.services;

public interface PlayerInterface {
    void movePosition(Long index);

    Boolean checkIfWon(Long winIndex);

    public Long makeMove(DiceInterface dice);
    public Long getCurrentPosition();
    public String getPlayerName();

}
