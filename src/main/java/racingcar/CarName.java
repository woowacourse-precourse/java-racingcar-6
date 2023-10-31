package racingcar;

import java.util.Objects;

public class CarName {
    private static final int MAX_LENGTH = 5;

    private final String value;

    CarName(String value) {
        validateNullOrEmpty(value);
        validateLengthLimit(value);
        this.value = value;
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.EMPTY);
        }
    }

    private void validateLengthLimit(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.SIZE_OVER);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
