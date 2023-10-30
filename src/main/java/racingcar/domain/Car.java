package racingcar.domain;

import racingcar.enums.GameCondition;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward() {
        position += GameCondition.CAR_SPEED.getValue();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
