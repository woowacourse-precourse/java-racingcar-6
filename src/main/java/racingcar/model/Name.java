package racingcar.model;

import racingcar.enums.Constants;
import racingcar.enums.Exceptions;
import racingcar.exception.CarNameIsNumberException;
import racingcar.exception.CarNameLengthException;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        validateNameLength(name);
        validateNameType(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void validateNameType(String carName) {
        if (isNumber(carName)) {
            throw new CarNameIsNumberException(Exceptions.CAR_NAME_IS_NOT_NUMBER.getMessage());
        }
    }

    private static boolean isNumber(String name) {
        try {
            Integer.parseInt(name);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateNameLength(String name) {
        if (isLengthOver5(name)) {
            throw new CarNameLengthException(Exceptions.CAR_NAME_IS_OVER_5.getMessage());
        }

        if (name.isBlank()) {
            throw new CarNameLengthException(Exceptions.CAR_NAME_IS_BLANK.getMessage());
        }
    }

    private boolean isLengthOver5(String name) {
        if (name.length() > Constants.NAME_LENGTH.getNumber()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
