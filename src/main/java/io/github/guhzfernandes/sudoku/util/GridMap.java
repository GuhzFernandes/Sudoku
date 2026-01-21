package io.github.guhzfernandes.sudoku.util;

public class GridMap {
    public static int column(char c) {
        char upper = Character.toUpperCase(c);
        if (upper < 'A' || upper > 'I') {
            throw new IllegalArgumentException("Letra fora do intervalo A-I: " + c);
        }
        return upper - 'A';
    }
    public static int row(int i) {
        if (i < 1 || i > 9) {
            throw new IllegalArgumentException("Valor fora do intervalor 1-9: " + i);
        }
        return i-1;
    }
}