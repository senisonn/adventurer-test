package fr.soheil.benabida.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adventurer {
    private int x;
    private int y;
    private Map map;

    public Adventurer(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }
}
