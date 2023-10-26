package racingcar.domain;

import static racingcar.exception.ExceptionMessage.CarException.INVALID_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.CarException.NAME_MUST_BE_EXISTS;

public class Car {
    private static final int NAME_LENGTH = 5;

    private final String name;

    private Car(final String name) {
        this.name = name;
    }

    public static Car from(final String name) {
        validateNameIsUsable(name);
        return new Car(name);
    }

    private static void validateNameIsUsable(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NAME_MUST_BE_EXISTS.message);
        }

        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.message);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
