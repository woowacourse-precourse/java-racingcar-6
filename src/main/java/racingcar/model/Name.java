package racingcar.model;

import racingcar.enums.Constants;
import racingcar.enums.Exceptions;
import racingcar.exception.CarNameLengthException;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
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
