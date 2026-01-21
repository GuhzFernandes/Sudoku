package io.github.guhzfernandes.sudoku.util;

public class InputMap {
    public static int[] writeCommand(String input) {
        String[] parts = input.trim().toUpperCase().split(" ");
        if (parts.length != 2 || parts[0].length() != 2) throw new IllegalArgumentException("Invalid format. Use: B2 5");

        return new int[] {
                GridMap.row(Character.getNumericValue(parts[0].charAt(1))),
                GridMap.column(parts[0].charAt(0)),
                Integer.parseInt(parts[1])
        };
    }
    public static int[] eraseCommand(String input) {
        input = input.trim().toUpperCase();
        if (input.length() != 2) throw new IllegalArgumentException("Invalid format. Use: B2");

        return new int[] {
                GridMap.row(Character.getNumericValue(input.charAt(1))),
                GridMap.column(input.charAt(0))
        };
    }
}
