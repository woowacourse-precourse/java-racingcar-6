package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_MOVE_DISTANCE = 4;
    private static final String INVALID_CAR_NAME_ERROR = "[ERROR] : 공백을 제외한 이름을 입력해주세요.";
    private static final String MISSING_CAR_NAME_ERROR = "[ERROR] : 자동차 이름을 입력해주세요.";
    private static final String CAR_NAME_LENGTH_LIMIT_ERROR = "[ERROR] : 5글자 이하의 자동차 이름을 입력해주세요";
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        checkNonEmptyName(name);
        checkNameLength(name);
        checkNameForWhitespace(name);
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    private void checkNonEmptyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MISSING_CAR_NAME_ERROR);
        }
    }

    private void checkNameForWhitespace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR);
        }
    }

    public void moveForward(int number) {
        if (number >= MINIMUM_MOVE_DISTANCE) {
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
