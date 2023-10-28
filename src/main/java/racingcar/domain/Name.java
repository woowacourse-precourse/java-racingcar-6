package racingcar.domain;

import racingcar.constant.ExceptionMessage;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > MAX_LENGTH) {
            ExceptionMessage exceptionMessage = ExceptionMessage.TOO_LONG_NAME_LENGTH;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
