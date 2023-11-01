package racingcar.domain;

import racingcar.utils.GameRules;

public class Car {
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = GameRules.START_POSITION.getValue();
    }

    public static Car from(String name) {
        isNotNull(name);
        isOverSize(name);
        return new Car(name);
    }

    private static void isNotNull(final String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOverSize(final String carName) {
        if (carName.length() > GameRules.NAME_LIMIT.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position++;
        }
    }

    public boolean isTopPosition(int topPosition) {
        return this.position == topPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
