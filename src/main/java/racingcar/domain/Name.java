package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "5자 이하의 이름만 가능합니다.";
    private static final String BLANK = " ";
    private static final String CAR_NAME_BLANK_EXCEPTION_MESSAGE = "자동차 이름에 공백이 있으면 안 됩니다.";

    private final String name;

    public Name(String name) {
        validateCarNameLength(name);
        validateCarNameHasBlank(name);
        this.name = name;
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
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateCarNameLength(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateCarNameHasBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION_MESSAGE);
        }
    }
}
