package org.abhk943.services;

import org.abhk943.exceptions.IllegalDataException;
import org.abhk943.interfaces.GameInterface;
import org.abhk943.models.Game;
import org.abhk943.models.Move;
import org.abhk943.models.User;
import org.abhk943.repository.GameRepository;
import org.abhk943.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GameService implements GameInterface {
    private GameRepository gameRepository = GameRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();


    @Override public void newGame(Long userId) throws IllegalDataException {
        User user = getCheckUser(userId);
        Game game = new Game();
        game.init();
        game.setId(1L);
        gameRepository.saveGame(game.getId(), game);

        user.setLastGameId(game.getId());
//        userRepository.updateUser(user.getId(), user);
    }

    @Override public void reset(Long userId) throws IllegalDataException {
        User user = getCheckUser(userId);
        Game game = gameRepository.getGame(user.getLastGameId());
        game.init();
//        gameRepository.saveGame(game.getId(), game);
    }

    @Override public void move(Long userId, Move move) throws IllegalDataException {
        User user = getCheckUser(userId);
        Game game = getCheckGame(user);
        int[][] state = game.getState();
        // write logic
        state[1][1] = 19;
        game.addState(state);
        game.addMove(move);
        Long score = (long) sumOfMatElmt(state);
        user.setHighScore(Math.max(user.getHighScore(), score));
    }

    private Game getCheckGame(User user) throws IllegalDataException {
        Game game = gameRepository.getGame(user.getLastGameId());
        if (Objects.isNull(game))
            throw new IllegalDataException("Game not started");
        return game;
    }

    @Override public Long getScore(Long userId) throws IllegalDataException {
        User user = getCheckUser(userId);
        Game game = getCheckGame(user);
        return (long) sumOfMatElmt(game.getState());
    }

    private User getCheckUser(Long userId) throws IllegalDataException {
        User user = userRepository.getUser(userId);
        if (Objects.isNull(user))
            throw new IllegalDataException("User not registered");
        return user;
    }

    @Override public void revert(Long userId) throws IllegalDataException {
        User user = getCheckUser(userId);
        Game game = getCheckGame(user);
        game.revert();
    }

    @Override public int[][] getState(Long userId) throws IllegalDataException {
        User user = getCheckUser(userId);
        return getCheckGame(user).getState();
    }

    public static int sumOfMatElmt(int[][] mat) {

        // declare and initialize the sum variable
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {

            // initiate the looping over each column of the current row
            for (int j = 0; j < mat[i].length; j++) {

                // Add the current element to the sum
                sum += mat[i][j];
            }
        }

        // Return the result
        return sum;
    }
}
