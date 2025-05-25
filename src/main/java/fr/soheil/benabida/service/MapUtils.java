package fr.soheil.benabida.service;

import fr.soheil.benabida.entity.Map;

public class MapUtils {

    public boolean isAccessible(Map map, int x, int y) {
        if (map != null) {
            if(x < 0 || y < 0 || x >= map.getWidth() || y >= map.getHeight()) {
                return false;
            }
            return map.getGrid()[y][x] == ' ';
        }
        return false;
    }
}
