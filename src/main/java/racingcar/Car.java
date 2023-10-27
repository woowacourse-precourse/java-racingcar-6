package racingcar;

import java.util.Objects;

final class Car {

    private Name name;
    private int moveCount;

    private Car() {
    }

    static Car create(String name) {
        Car instance = new Car();
        instance.name = new Name(name);
        instance.moveCount = 0;
        return instance;
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
