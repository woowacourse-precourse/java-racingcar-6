package racingcar.domain;

import racingcar.util.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MOVING = 1;
    private static final int STOPPED = 0;

    private final List<String> names;
    private Map<String, Integer> positions;
    private int farthestPosition;

    public Car(List<String> names) {
        this.names = names;
        Validation.validateCarNames(names);
        initPositions();
    }

    private void initPositions() {
        positions = new HashMap<>();
        names.forEach(name -> positions.put(name, START_POSITION));
    }

    public RaceResultDTO oneCarRace() {
        moveCars();
        updateFarthestPosition();
        return new RaceResultDTO(names, positions);
    }

    private void moveCars() {
        names.forEach(name -> updatePosition(name, getPosition(name) + getStep()));
    }

    private int getPosition(String name) {
        return positions.get(name);
    }

    private int getStep() {
        if (RandomCarStateGenerator.generate() == CarState.MOVING) {
            return MOVING;
        }
        return STOPPED;
    }

    private void updatePosition(String name, int position) {
        positions.replace(name, position);
    }

    private void updateFarthestPosition() {
        positions.values()
                .stream()
                .filter(position -> position > farthestPosition)
                .forEach(position -> farthestPosition = position);
    }

    public List<String> getWinners() {
        return names.stream()
                .filter(name -> getPosition(name) == farthestPosition)
                .collect(Collectors.toList());
    }
}