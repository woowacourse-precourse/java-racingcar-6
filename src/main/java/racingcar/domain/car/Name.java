package racingcar.domain.car;

import java.util.Objects;

import static racingcar.constants.ErrorConstants.*;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
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
        return Objects.hash(name);
    }

}