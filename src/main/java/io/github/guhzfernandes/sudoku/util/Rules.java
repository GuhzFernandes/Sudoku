package io.github.guhzfernandes.sudoku.util;

public class Rules {
    public static void print() {
        System.out.println("========= SUDOKU RULES =========");
        System.out.println("- Fill each row, column, and 3x3 box with numbers from 1 to 9.");
        System.out.println("- No repeating numbers in rows, columns, or boxes.");
        System.out.println("- Fixed numbers (from the puzzle) cannot be changed.");
        System.out.println("- Only empty cells can be filled or cleared by the player.");
        System.out.println("- The game is complete when all cells are correctly filled.");
        System.out.println("========= ============ =========");
    }
}
