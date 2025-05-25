package fr.soheil.benabida.app;

import fr.soheil.benabida.constant.DirectoryConstants;
import fr.soheil.benabida.entity.Adventurer;
import fr.soheil.benabida.entity.Map;
import fr.soheil.benabida.service.AdventurerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(DirectoryConstants.DIRECTIONS_PATH))) {
            Map map = new Map(DirectoryConstants.MAP_PATH);
            AdventurerUtils adventurerUtils = new AdventurerUtils();
            String[] position = br.readLine().split(",");
            int startX = Integer.parseInt(position[0]);
            int startY = Integer.parseInt(position[1]);

            String instructions = br.readLine();

            Adventurer adventurer = new Adventurer(startX, startY, map);
            adventurerUtils.followInstructions(instructions, adventurer);

            logger.info("Final position: ({}, {})", adventurer.getX(), adventurer.getY());
        } catch (IOException e) {
            logger.error("Error reading direction file: {}", e.getMessage(), e);
        }
    }
}
