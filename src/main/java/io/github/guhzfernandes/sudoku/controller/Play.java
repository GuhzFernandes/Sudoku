package io.github.guhzfernandes.sudoku.controller;

import io.github.guhzfernandes.sudoku.model.Grid;
import io.github.guhzfernandes.sudoku.repository.GameSaver;
import io.github.guhzfernandes.sudoku.util.InputMap;
import java.util.Scanner;

public class Play {

    public static void run(Grid game, Scanner input) {
        boolean playing = true;

        while (playing) {
            if(game.endGame()){
                System.out.println("🎉✨ Congratulations! ✨🎉");
                System.out.println("You have successfully completed the Sudoku puzzle!");
                System.out.println("Returning to main menu...");
                System.out.println("========================================\n");
                break;
            }
            else {
                game.print();
                System.out.println("========= IN-GAME MENU =========");
                System.out.println("1. Place a Number");
                System.out.println("2. Erase a Number");
                System.out.println("3. Reset Puzzle");
                System.out.println("4. Save Game");
                System.out.println("0. Exit to Main Menu");
                System.out.print("Choose an action: ");

                String option = input.nextLine().trim();
                System.out.println();

                try {
                    switch (option) {
                        case "1":
                            System.out.print("Enter input (e.g. A1 5): ");
                            int[] placeCmd = InputMap.writeCommand(input.nextLine());
                            game.writeCell(placeCmd[0], placeCmd[1], placeCmd[2]);
                            break;
                        case "2":
                            System.out.print("Enter cell to erase (e.g. A1): ");
                            int[] eraseCmd = InputMap.eraseCommand(input.nextLine());
                            game.eraseCell(eraseCmd[0], eraseCmd[1]);
                            break;
                        case "3":
                            System.out.println("Resetting puzzle...");
                            game.reset();
                            game.print();
                            break;
                        case "4":
                            System.out.println("Saving game...");
                            GameSaver.saveGame(game);
                            break;
                        case "0":
                            playing = false;
                            System.out.println("Returning to main menu...");
                            break;
                        default:
                            System.out.println("Invalid option. Choose from 0 to 4.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            System.out.println();
        }
    }
}
