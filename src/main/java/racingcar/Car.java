package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    public static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        verifyName(name);
        this.name = name;
    }

    private void verifyName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("car name can't be null");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("car name length should be under " + MAX_NAME_LENGTH);
        }
    }

    public boolean isSame(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("car can't be null");
        }
        return Objects.equals(this.name, car.name);
    }
}
