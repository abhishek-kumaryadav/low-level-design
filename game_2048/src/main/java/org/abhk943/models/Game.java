package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Long id;
    private List<int[][]> states;
    private List<Move> moves;

    public int[][] getState(){
        return this.states.get(this.states.size()-1);
    }

    public void addState(int[][] state){
        this.states.add(state);
    }

    public void addMove(Move move){
        this.moves.add(move);
    }

    public void init(){
        this.states = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.states.add(new int[4][4]);
        this.states.get(0)[0][0] = 1;
        this.states.get(0)[0][1] = 2;
    }

    public void revert() {
        this.states.remove(this.states.size()-1);
        this.moves.remove(this.moves.size()-1);
    }
}
