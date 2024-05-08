package org.abhk943.repository;

import org.abhk943.models.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameRepository {

    private static GameRepository gameRepository;
    private Map<Long, Game> gameIdToGameMap;
    private GameRepository (){
        this.gameIdToGameMap = new HashMap<>();
    }

    public Game getGame(Long gameId){
        return gameIdToGameMap.get(gameId);
    }

    public static GameRepository getInstance(){
        if(Objects.isNull(gameRepository)){
            gameRepository = new GameRepository();
        }
        return gameRepository;
    }

    public void saveGame(Long id, Game game) {
        this.gameIdToGameMap.put(id, game);
    }
}
