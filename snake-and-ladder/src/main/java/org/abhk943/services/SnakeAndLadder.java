package org.abhk943.services;

import org.abhk943.exceptions.IllegalInputException;
import org.abhk943.model.Ladder;
import org.abhk943.model.Snake;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadder {
    private BoardInterface board;
    private List<PlayerInterface> playersList;
    private DiceInterface dice;
    private Long currentPlayer;

    public SnakeAndLadder() {
        this.board = new Board();
        this.playersList = new ArrayList<>();
        this.currentPlayer = null;
        this.dice = new Dice();
    }

    public void addLadder(Long startPoint, Long endPoint) throws IllegalInputException {
        this.board.addLadder(new Ladder(startPoint, endPoint));
    }

    public void addSnake(Long startPoint, Long endPoint) throws IllegalInputException {
        this.board.addSnake(new Snake(startPoint, endPoint));
    }

    public void addPlayer(Long id, String name, String color){
        Player player = new Player(name, color, id);
        if (playersList.isEmpty())
            currentPlayer = 0L;
        playersList.add(player);
    }

    public String getCurrentPlayerName(){
        return this.playersList.get(Math.toIntExact(this.currentPlayer)).getPlayerName();
    }

    public Long getCurrentPlayerPosition(){
        return this.playersList.get(Math.toIntExact(this.currentPlayer)).getCurrentPosition();
    }

    public Long makeMove(){
        Long nextPosition = this.playersList.get(Math.toIntExact(currentPlayer)).makeMove(this.dice);
        if (nextPosition > Board.BOARD_SIZE)
            nextPosition = this.playersList.get(Math.toIntExact(currentPlayer)).makeMove(this.dice);
        Long finalPosition = board.getFinalPosition(nextPosition);
        this.playersList.get(Math.toIntExact(currentPlayer)).movePosition(finalPosition);
        currentPlayer = (currentPlayer + 1) % playersList.size();
        return this.playersList.get(Math.toIntExact(currentPlayer)).getCurrentPosition();
    }
}
