package racingcar.domain;

import racingcar.utils.GameRules;

public class Car {
    private final String name;
    private int position;
    private final MovableStrategy movableStrategy;

    private Car(String name, MovableStrategy movableStrategy) {
        this.name = name;
        this.position = GameRules.START_POSITION.getValue();
        this.movableStrategy = movableStrategy;
    }

    public static Car createCar(String name) {
        isNotNull(name);
        isOverSize(name);
        return new Car(name, RandomMoveStrategy.createStrategy());
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

    public boolean isWinner(int position) {
        return this.position == position;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
