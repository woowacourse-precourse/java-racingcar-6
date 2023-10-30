package racingcar.model;

import static racingcar.constant.Constant.RULE_CAR_MOVE;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (RandomNumberGenerator.generate() >= RULE_CAR_MOVE) {
            position++;
        }
    }
}
