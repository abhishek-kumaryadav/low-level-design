package org.abhk943;

import org.abhk943.exceptions.IllegalDataException;
import org.abhk943.models.Game;
import org.abhk943.models.Move;
import org.abhk943.services.GameService;
import org.abhk943.services.UserService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalDataException {

        GameService gameService = new GameService();
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        Long userId = userService.register(name);
        gameService.newGame(userId);
        while(gameService.getScore(userId) < 2048){
            for( int[] row : gameService.getState(userId)){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Enter move to change state");
            String move = scanner.nextLine();
            gameService.move(userId, Move.valueOf(move));
        }
    }
}