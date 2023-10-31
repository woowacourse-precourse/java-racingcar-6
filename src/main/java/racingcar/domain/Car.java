package racingcar.domain;

import racingcar.enums.Movement;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveCondition) {
        if (moveCondition >= Movement.MIN_MOVE_CONDITION.getValue()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
