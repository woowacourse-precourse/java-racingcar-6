package racingcar.domain;

import static racingcar.constant.GameNumber.MOVE_NUMBER;

import racingcar.Utils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Utils.createRandomNumber() >= MOVE_NUMBER) {
            position++;
        }
    }
}
