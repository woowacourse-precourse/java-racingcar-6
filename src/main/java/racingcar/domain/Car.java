package racingcar.domain;

import static racingcar.exception.ExceptionMessage.CarException.INVALID_NAME_LENGTH;

public class Car {
    private static final int NAME_LENGTH = 5;

    private final String name;

    private Car(final String name) {
        this.name = name;
    }

    public static Car from(final String name) {
        validateNameLength(name);
        return new Car(name);
    }

    private static void validateNameLength(final String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.message);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
