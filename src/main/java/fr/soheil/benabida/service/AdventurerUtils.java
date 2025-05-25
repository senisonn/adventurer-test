package fr.soheil.benabida.service;

import fr.soheil.benabida.entity.Adventurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdventurerUtils {
    private MapUtils mapUtils = new MapUtils();
    private static final Logger logger = LoggerFactory.getLogger(AdventurerUtils.class.getName());

    public void move(char direction, Adventurer adventurer) {
        int nx = adventurer.getX();
        int ny = adventurer.getY();

        switch (direction) {
            case 'N':
                ny--;
                logger.info("Willing to go north: N");
                break;
            case 'S':
                ny++;
                logger.info("Willing to go south: S");
                break;
            case 'E':
                nx++;
                logger.info("Willing to go east: E");
                break;
            case 'O':
                nx--;
                logger.info("Willing to go west: O");
                break;
            default:
                logger.error("Invalid direction: {}", direction);
                return;
        }

        if (mapUtils.isAccessible(adventurer.getMap(), nx, ny)) {
            adventurer.setX(nx);
            adventurer.setY(ny);
            logger.info("Moving successful, adventurer at ({}, {})", nx, ny);
        } else {
            logger.error("Moving failed: destination not accessible.");
        }
    }

    public void followInstructions(String instructions, Adventurer adventurer) {
        for (char dir : instructions.toCharArray()) {
            move(dir, adventurer);
        }
    }
}
