package racingcar.domain;

import racingcar.constant.message.ExceptionMessage;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance;

    public Car(final Car car) {
        this.name = car.name;
    }

    public Car(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void increaseDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_NAME_LENGTH.getMessage());
        }
    }
}
