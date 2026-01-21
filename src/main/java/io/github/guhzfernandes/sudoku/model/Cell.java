package io.github.guhzfernandes.sudoku.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell {
    @JsonProperty
    private String currentValue;
    @JsonProperty
    private String expectedValue;
    @JsonProperty
    private boolean fixedValue;


    public Cell(){
    }

    public Cell(String currentValue, String expectedValue) {
        this.currentValue = currentValue;
        this.expectedValue = expectedValue;
        this.fixedValue = !currentValue.equals("0");
    }

    //possibly usefull for GUI implementation
    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String value) {
        if (!fixedValue) this.currentValue = value;
    }

    public boolean checkValue(){
        return currentValue.equals(expectedValue);
    }

    public void clearValue(){
        setCurrentValue("0");
    }

    @JsonIgnore
    public String getDisplayValue() {
        if (currentValue.equals("0")) return " ";
        if (fixedValue) return currentValue;
        if (!checkValue()) return "\u001B[31m" + currentValue + "\u001B[0m"; //red
        return "\u001B[32m" + currentValue + "\u001B[0m"; //gren
    }
}