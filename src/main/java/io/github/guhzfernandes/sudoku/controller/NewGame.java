package io.github.guhzfernandes.sudoku.controller;

import io.github.guhzfernandes.sudoku.model.Grid;
import io.github.guhzfernandes.sudoku.model.SudokuEntry;
import io.github.guhzfernandes.sudoku.repository.GameLoader;
import java.util.List;
import java.util.Scanner;

public class NewGame {
    public static Grid run(Scanner input) {
        return new Grid(selectPuzzle(loadPuzzles(), input));
    }

    private static List<SudokuEntry> loadPuzzles(){
        List<SudokuEntry> entries;
        try {
            entries = GameLoader.loadDB();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entries;
    }

    private static SudokuEntry selectPuzzle(List<SudokuEntry> entries, Scanner input){
        System.out.println("Total of games available: " + entries.size());
        System.out.println("[ 1 ~ "+entries.size()+" ]");
        System.out.print("Please, select a game to start: ");
        int command = Integer.parseInt(input.nextLine().trim())-1;
        if(command >= 0 && command < entries.size()) return entries.get(command);
        else throw new IllegalArgumentException("Invalid game numeber. Choose a number between 1 ~ " + entries.size());
    }

}
