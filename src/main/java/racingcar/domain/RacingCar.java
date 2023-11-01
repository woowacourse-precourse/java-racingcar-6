package racingcar.domain;

import racingcar.exception.NonNullCarNameException;

public class RacingCar {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int location;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NonNullCarNameException();
        }
    }

    private void increaseLocation() {
        this.location++;
    }

    public void goForwardOrStop(int pickNumber) {
        if (pickNumber >= MOVE_THRESHOLD) {
            increaseLocation();
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(location);
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }
}
