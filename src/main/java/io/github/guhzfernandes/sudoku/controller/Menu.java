package io.github.guhzfernandes.sudoku.controller;
import io.github.guhzfernandes.sudoku.model.Grid;
import io.github.guhzfernandes.sudoku.repository.GameLoader;
import io.github.guhzfernandes.sudoku.util.Rules;

import java.util.Scanner;

public class Menu {

    public static void run() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("========= SUDOKU MENU =========");
            System.out.println("1. Rules");
            System.out.println("2. New Game");
            System.out.println("3. Load Game");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String option = input.nextLine().trim();
            switch (option) {
                case "1":
                    Rules.print();
                    break;
                case "2":
                    System.out.println("\n\n-> [New Game] Select a puzzle from the database.");
                    try{
                        Grid game = NewGame.run(input);
                        Play.run(game,input);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case "3":
                    System.out.println("-> [Load Game] Load from a saved file.");
                    try {
                        Grid game = GameLoader.loadSave();
                        Play.run(game, input);
                    } catch (Exception e) {
                        System.out.println("❌ Could not load saved game: " + e.getMessage());
                    }
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, 2 or 3.");
            }

            System.out.println();
        }
        input.close();
    }
}
