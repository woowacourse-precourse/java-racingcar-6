package racingcar.model;

import java.util.Objects;

public final class Name {
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
            throw new IllegalArgumentException("자동차 이름은 null 이 될 수 없다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없다.");
        }
        if (isOverNumberFive(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    private static boolean isOverNumberFive(String name) {
        return name.length() > 5;
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
