package racingcar.model;

import java.util.Objects;
import racingcar.constant.ErrorMessages;
import racingcar.constant.NumberLimits;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNonEmptyName(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > NumberLimits.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private void checkNonEmptyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.MISSING_CAR_NAME_ERROR);
        }
    }

    public void moveForward(int number) {
        if (number >= NumberLimits.MINIMUM_MOVE_DISTANCE) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
