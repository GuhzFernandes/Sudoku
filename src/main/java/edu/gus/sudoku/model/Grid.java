package edu.gus.sudoku.model;

import edu.gus.sudoku.util.GridConsole;

import java.util.Arrays;

public class Grid {
    private Cell[][] cells;

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

    /*public void checkValues(){
        for (int i=0;i<9;i++){
            for (int j = 0; j<9; j++){
                cells[i][j].checkValue();
            }
        }
    }*/

    public void writeCell (int row, int column, int value){
        cells[row][column].setCurrentValue(Integer.toString(value));
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

        System.out.println(String.format(GridConsole.PRINT,values));
    }

}
