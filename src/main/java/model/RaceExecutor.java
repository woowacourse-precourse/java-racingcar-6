package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class RaceExecutor {

    private final MovementDecider movementDecider = new MovementDecider();
    private final RaceDto raceDto;

    RaceExecutor(RaceDto raceDto) {
        this.raceDto = raceDto;
    }

    public RaceDto singleAttempt() {
        Set<String> nameSet = raceDto.getCars().keySet();
        for (String name : nameSet) {
            moveCarAtIfPossible(name);
        }
        return raceDto;
    }

    private void moveCarAtIfPossible(String name) {
        if (movementDecider.decide()) {
            moveCarByName(name);
        }
    }

    private void moveCarByName(String name) {
        int originalValue = raceDto.getCars().get(name);
        raceDto.getCars().put(name, originalValue + 1);
    }
}
