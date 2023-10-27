package racingcar;

import java.util.Objects;

final class Car {

    private final Name name;
    private int moveCount;

    Car(String name) {
        this.name = new Name(name);
        this.moveCount = 0;
    }

    void move() {
        moveCount++;
    }

    String currentStatus() {
        return name.name() + " : " + "-".repeat(moveCount);
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
