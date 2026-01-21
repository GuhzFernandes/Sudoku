package io.github.guhzfernandes.sudoku.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.guhzfernandes.sudoku.model.Grid;
import io.github.guhzfernandes.sudoku.model.SudokuEntry;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class GameLoader {
    public static List<SudokuEntry> loadDB() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream input = GameLoader.class
                .getClassLoader()
                .getResourceAsStream("db.json");
        if (input == null) throw new RuntimeException("File not founded!");
        SudokuEntry[] array = mapper.readValue(input, SudokuEntry[].class);
        return Arrays.asList(array);
    }

    public static Grid loadSave() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File saveFile = new File("save.json");
        if (!saveFile.exists()) throw new RuntimeException("⚠️ No save founded! Please start a new game.");
        return mapper.readValue(saveFile, Grid.class);
    }
}
