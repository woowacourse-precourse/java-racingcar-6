package racingcar;

import java.util.Objects;

final class Car {

    private final Name name;
    private int moveCount;

    Car(String name) {
        this.name = new Name(name);
        this.moveCount = 0;
    }

    int move() {
        return ++moveCount;
    }

    boolean isFront(int front) {
        return moveCount == front;
    }

    String currentStatus() {
        return name.name() + Constant.COLON.value + Constant.DASH.value.repeat(moveCount);
    }

    String getName() {
        return name.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
