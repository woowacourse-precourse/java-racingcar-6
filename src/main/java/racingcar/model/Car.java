package racingcar.model;

import racingcar.global.Constants;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() { return this.name; }
    public int getMoveCount() { return this.moveCount; }

    public void moveForward(int randomNum) {
        if (randomNum >= Constants.MIN_MOVING_RANDOM_NUM) {
            this.moveCount++;
        }
    }
}
