package racingcar.model;

import racingcar.util.RandomNumber;

public class Car {
    private final String carName;
    private int movedDistance;

    public Car(String carName) {
        this.carName = carName;
        this.movedDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public boolean isMovable(int number) {
        return number >= RandomNumber.MOVABLE_MIN;
    }

    public void move(int number) {
        if (isMovable(number)) {
            movedDistance++;
        }
    }

}
