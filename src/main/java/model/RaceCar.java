package model;

import java.util.ConcurrentHashMap;

public class RaceCar {
    private String name;
    private int moveForwardCount;

    public RaceCar(String name, int moveForwardCount) {
        this.name = name;
        this.moveForwardCount = moveForwardCount;
    }
    public String getName() {
        return new String(name);
    }

    public int getMoveForwardCount() {
        int copyMoveForwardCount = moveForwardCount;
        return copyMoveForwardCount;
    }

    public ConcurrentHashMap<String, Integer> getNameAndMoveForwardCount() {
        return new ConcurrentHashMap<String, Integer>(name, moveForwardCount);
    }

}
