package io.github.guhzfernandes.sudoku.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.guhzfernandes.sudoku.model.Grid;

import java.io.File;
import java.io.IOException;

public class GameSaver {

    private static final String SAVE_PATH = "save.json";
    public static void saveGame(Grid game) {
        ObjectMapper mapper = new ObjectMapper();
        File saveFile = new File(SAVE_PATH);
        try {
            if (saveFile.exists()) if (!saveFile.delete()) throw new IOException("Failed to delete previous save file.");
            mapper.writeValue(saveFile, game);
            System.out.println("✅ Game saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error while saving the game: " + e.getMessage());
        }
    }
}
