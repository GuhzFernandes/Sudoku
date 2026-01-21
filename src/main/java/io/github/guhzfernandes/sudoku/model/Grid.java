package io.github.guhzfernandes.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.guhzfernandes.sudoku.util.GridConsole;
import java.util.Arrays;

public class Grid {
    @JsonProperty
    private Cell[][] cells;

    public Grid(){

    }

    public Grid(SudokuEntry sudokuEntry) {
        cells = new Cell[9][9];
        int index = 0;

        for (int i=0;i<9;i++){
            for (int j = 0; j<9; j++){
                cells[i][j] = new Cell(String.valueOf(sudokuEntry.puzzle.charAt(index)),
                                        String.valueOf(sudokuEntry.solution.charAt(index)));
                index++;
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void writeCell (int row, int column, int value){
        cells[row][column].setCurrentValue(Integer.toString(value));
    }

    public void eraseCell (int row, int column){
        cells[row][column].clearValue();
    }

    public void reset(){
        for (int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j].clearValue();
            }
        }
    }

    public void print(){
        String[] values = Arrays.stream(cells)
                .flatMap(Arrays::stream)
                .map(Cell::getDisplayValue)
                .toArray(String[]::new);

        System.out.println("\n\n");
        System.out.println(String.format(GridConsole.PRINT,values));
    }

    public boolean endGame(){
        return Arrays.stream(cells).flatMap(Arrays::stream).map(Cell::checkValue).allMatch(x-> x);
    }

}
