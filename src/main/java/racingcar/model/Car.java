package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Car(final String name) {
        validateSize(name);
        this.name = name;
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름 크기는 5이하여야 합니다.");
        }
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
