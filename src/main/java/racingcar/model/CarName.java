package racingcar.model;

import racingcar.exception.CarException;

import java.util.Objects;

import static racingcar.exception.ErrorMessage.*;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if(NAME_MAX_LENGTH < name.length())
            throw new CarException(NAME_TOO_LONG);
    }

    private void validateEmptyName(final String name) {
        if(name == null)
            throw new CarException(NULL_NAME);
        if(name.isBlank())
            throw new CarException(EMPTY_NAME);
    }

    @Override
    public String toString() {
        return this.name;
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
