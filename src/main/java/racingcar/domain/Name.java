package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MIN_LENGTH_OF_NAME = 1;
    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        int length = name.length();

        if (length < MIN_LENGTH_OF_NAME || length > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format("자동차의 이름은 %d자 이상, %d자 이하여야 합니다.", MIN_LENGTH_OF_NAME, MAX_LENGTH_OF_NAME)
            );
        }
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
