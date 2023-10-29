package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class RaceCar {
    private final String name;
    private StringBuilder moveForwardCount = new StringBuilder();

    public RaceCar(String name) {
        this.name = name;
    }

    public void MoveForward() {
        moveForwardCount.append("-");
    }

    public String getName() {
        return new String(name);
    }

    public StringBuilder getMoveForwardCount() {
        return new StringBuilder(moveForwardCount);
    }

}
