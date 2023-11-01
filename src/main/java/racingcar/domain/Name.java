package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Objects;

public class Name {

    private static final String NAME_NOT_EMPTY_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    private static final String NAME_NOT_OVER_MAX_LENGTH_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        nameValidation(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

    private void nameValidation(String name) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(NAME_NOT_EMPTY_MESSAGE);
        }
        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_NOT_OVER_MAX_LENGTH_MESSAGE);
        }
    }
}
