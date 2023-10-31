package racingcar.service.domain;

import java.util.Objects;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String COMMA = ",";
    private static final String OUT_OF_LENGTH = "자동차 이름의 길이는 1 ~ 5자리여야 합니다.";
    private static final String COMMA_EXISTS = "자동차 이름에 콤마(,)가 있으면 안됩니다.";
    private static final String BLANK_EXISTS = "자동차 이름에 공백만 존재하면 안됩니다.";

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

    private static void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_LENGTH);
        }
    }

    private static void validateCommaExists(String name) {
        if (name.contains(COMMA)) {
            throw new IllegalArgumentException(BLANK_EXISTS);
        }
    }

    private static void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(COMMA_EXISTS);
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
