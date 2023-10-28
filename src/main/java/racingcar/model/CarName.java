package racingcar.model;

import static racingcar.model.ExceptionMessage.BLANK_NAME_EXCEPTION_MESSAGE;
import static racingcar.model.ExceptionMessage.CAR_NAME_OVER_LIMIT_FORMAT_MESSAGE;

import java.util.Objects;

public final class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    
    private final String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(BLANK_NAME_EXCEPTION_MESSAGE);
        }
    }

    private boolean isBlank(String name) {
        return name.isBlank();
    }

    private void validateLength(String name) {
        if (isOverLength(name)) {
            String exceptionMessage = String.format(CAR_NAME_OVER_LIMIT_FORMAT_MESSAGE, MAX_NAME_LENGTH);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isOverLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
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
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
