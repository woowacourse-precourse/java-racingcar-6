package racingcar.service.domain;

import java.util.Objects;
import racingcar.configuration.ConfigurationConstants;
import racingcar.utils.CarExceptionMessage;

public class CarName {
    private static final String COMMA = ",";
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateCommaExists(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CarExceptionMessage.ONLY_BLANK_NAME.getError());
        }
    }

    private void validateCommaExists(String name) {
        if (name.contains(COMMA)) {
            throw new IllegalArgumentException(CarExceptionMessage.COMMA_EXISTS.getError());
        }
    }

    private void validateLength(String name) {
        if (name.isEmpty() || name.length() > ConfigurationConstants.CAR_NAME_LENGTH_MAX_LIMIT) {
            throw new IllegalArgumentException(CarExceptionMessage.OUT_OF_NAME_LENGTH.getError());
        }
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
