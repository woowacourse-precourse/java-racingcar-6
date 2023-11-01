package racingcar.model;

import static java.util.Objects.isNull;
import static racingcar.common.exception.ErrorMessage.EMPTY_NAME;
import static racingcar.common.exception.ErrorMessage.NAME_TOO_LONG;
import static racingcar.common.exception.ErrorMessage.NULL_NAME;

import java.util.Objects;
import racingcar.common.exception.CarException;

public class Name {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Name(final String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if(name.length() > MAX_LENGTH_OF_NAME) throw new CarException(NAME_TOO_LONG);
    }

    private void validateEmptyName(final String name) {
        if(isNull(name)) throw new CarException(NULL_NAME);
        if(name.isBlank()) throw new CarException(EMPTY_NAME);
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
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
