package racingcar.domain;

import static racingcar.exception.ExceptionMessage.CarException.INVALID_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.CarException.NAME_MUST_BE_EXISTS;

public class CarName {
    private static final int NAME_LENGTH = 5;

    private final String name;

    private CarName(final String name) {
        this.name = name;
    }

    public static CarName from(final String name) {
        validateNameIsUsable(name);
        return new CarName(name);
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
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final CarName other = (CarName) object;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
