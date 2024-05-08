package org.abhk943;

import org.abhk943.exceptions.IllegalInputException;
import org.abhk943.services.SnakeAndLadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalInputException {
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter number of snakes");
        Long snakes = Long.valueOf(inputScanner.nextLine());
        for(int i = 0;i<snakes;i++){
            System.out.println("Enter head and tail point of the snake");
            String positionInput = inputScanner.nextLine();
            String[] inputArray = positionInput.split(" ");
            snakeAndLadder.addSnake(Long.valueOf(inputArray[0]), Long.valueOf(inputArray[1]));
        }
        System.out.println("Enter number of ladders");
        Long ladder = Long.valueOf(inputScanner.nextLine());
        for(int i = 0;i<ladder;i++){
            System.out.println("Enter bottom and top point of the ladder");
            String positionInput = inputScanner.nextLine();
            String[] inputArray = positionInput.split(" ");
            snakeAndLadder.addLadder(Long.valueOf(inputArray[0]), Long.valueOf(inputArray[1]));
        }
        System.out.println("Enter number of players");
        Long players = Long.valueOf(inputScanner.nextLine());
        for(int i = 0;i<players;i++){
            System.out.println("Enter name of the player");
            String positionInput = inputScanner.nextLine();
            snakeAndLadder.addPlayer((long) i, positionInput, "Red");
        }
    }
}