package racingcar.domain;

import racingcar.utils.GameRules;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name) && Objects.equals(movableStrategy, car.movableStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, movableStrategy);
    }
}
