package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private CarName(final String name) {
        validate(name);
        this.name = name;
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 빈 문자열입니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과했습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
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
