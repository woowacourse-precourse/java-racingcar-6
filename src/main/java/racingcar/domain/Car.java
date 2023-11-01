package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private String name;
    private int progressCount;

    public Car(String name) {
        this.name = name;
        this.progressCount = 0;
    }

    public void moveForwardCar(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.progressCount++;
        }
    }

    public String getCarName() {
        return this.name;
    }

    public int getProgressCount() {
        return this.progressCount;
    }
}
