package fr.soheil.benabida.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Map {

    private char[][] grid;
    private int width;
    private int height;

    public Map(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        height = lines.size();
        width = lines.getFirst().length();
        grid = new char[height][width];
        for (int y = 0; y < height; y++) {
            grid[y] = lines.get(y).toCharArray();
        }
    }
}
