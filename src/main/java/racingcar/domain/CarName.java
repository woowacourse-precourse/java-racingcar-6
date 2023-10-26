package racingcar.domain;

import static racingcar.exception.ExceptionMessage.CarException.INVALID_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.CarException.NAME_MUST_BE_EXISTS;

public class CarName {
    private static final int NAME_LENGTH = 5;

    private final String value;

    private CarName(final String value) {
        this.value = value;
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

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final CarName other = (CarName) object;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
