package racingcar.domain;

import racingcar.enums.GameCondition;

public class Car {
    private final String name;
    private int position = GameCondition.START_POSITION.getValue();

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward() {
        position += GameCondition.CAR_SPEED.getValue();
    }


    public boolean isMaxPosition(final int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
