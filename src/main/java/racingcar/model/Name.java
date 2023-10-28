package racingcar.model;

import java.util.Objects;

import static racingcar.utils.ErrorMessage.*;

public final class Name {
    private static final int NUMBER_FIVE = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        checkValid(name);
        return new Name(name);
    }

    private static void checkValid(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_NULL.getMessage());
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_EMPTY.getMessage());
        }
        if (isOverNumberFive(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    private static boolean isOverNumberFive(String name) {
        return name.length() > NUMBER_FIVE;
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

    /**
     * 자동차 이름을 반환한다.
     */
    @Override
    public String toString() {
        return name;
    }
}
