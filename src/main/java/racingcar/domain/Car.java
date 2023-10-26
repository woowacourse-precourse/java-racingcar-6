package racingcar.domain;

import racingcar.util.RandomNumber;

public class Car {

    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        if (RandomNumber.canMove(RandomNumber.createRandomNumber())) {
            moveDistance += 1;
        }
    }

}
