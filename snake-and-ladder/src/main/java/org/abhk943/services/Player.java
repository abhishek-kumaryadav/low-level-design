package org.abhk943.services;


public class Player implements PlayerInterface {
    private String color;
    private Long id;
    private String name;
    private Long currentPostion;

    public Player(String name, String color, Long id) {
        this.name= name;
        this.color = color;
        this.id = id;
        this.currentPostion = 0L;
    }

    @Override public void movePosition(Long index){
        this.currentPostion = index;
    }
    @Override public Boolean checkIfWon(Long winIndex) {
        return currentPostion.equals(winIndex);
    }

    @Override public Long makeMove(DiceInterface dice) {
        return currentPostion + dice.roll();
    }

    @Override public Long getCurrentPosition() {
        return currentPostion;
    }

    @Override public String getPlayerName() {
        return this.name;
    }
}
