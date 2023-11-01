package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVING_THRESHOLD = 4;
    private static final int MINIMUM_RANDOM_VALUE = 0;
    private static final int MAXIMUM_RANDOM_VALUE = 0;

    private String name;
    private int currentLocation;

    private Car() {
    }

    Car(String name) {
        this.name = name;
        this.currentLocation = 0;
    }

    public void setCurrentLocation(int locationValue) {
        this.currentLocation = locationValue;
    }

    public String getCurrentStatus() {
        return this.name + ": " + "-".repeat(this.currentLocation);
    }

    public boolean canMoveForward(int randomValue) {
        return randomValue >= MOVING_THRESHOLD;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
        if (canMoveForward(randomValue)) {
            this.currentLocation++;
        }
    }
}
