package org.abhk943.services;

import org.abhk943.exceptions.IllegalInputException;
import org.abhk943.model.Edge;
import org.abhk943.model.Ladder;
import org.abhk943.model.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board implements BoardInterface {
    private List<Ladder> ladderList;
    private List<Snake> snakeList;
    private Map<Long, Long> boardGraph;
    public static final Long BOARD_SIZE = 100L;

    public Board(){
        this.ladderList = new ArrayList<>();
        this.snakeList = new ArrayList<>();
        this.boardGraph = new HashMap<>();
    }

    @Override public void addLadder(Ladder ladder) throws IllegalInputException {
        addEdge(ladder);
        ladderList.add(ladder);
    }

    @Override public void addSnake(Snake snake) throws IllegalInputException {
        addEdge(snake);
        snakeList.add(snake);
    }

    @Override public Long getFinalPosition(Long currentPosition) {
        while(boardGraph.containsKey(currentPosition)){
            currentPosition = boardGraph.get(currentPosition);
        }
        return currentPosition;
    }

    private void addEdge(Edge edge) throws IllegalInputException {
        if (boardGraph.containsKey(edge.getStartPoint())) {
            throw new IllegalInputException("A snaker or ladder already exists with this start point");
        }
        if (edge.getEndPoint().equals(BOARD_SIZE))
            throw new IllegalInputException("The snake or ladder goes outside board");
        if (checkCycleExists(edge))
            throw new IllegalInputException("Adding this snake or ladder will create a cycle in the board");
        boardGraph.put(edge.getStartPoint(), edge.getEndPoint());
    }

    private boolean checkCycleExists(Edge ladder) {
        boardGraph.put(ladder.getStartPoint(), ladder.getEndPoint());
        // algo
        Boolean cycleExists = checkCycle();
        boardGraph.remove(ladder.getStartPoint());
        return cycleExists;
    }

    private Boolean checkCycle() {
        return Boolean.FALSE;
    }
}
