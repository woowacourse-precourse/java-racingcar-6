package racingcar.domain;

import racingcar.util.ExceptionMessage;

public class Name {
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;
    private final String name;

    public Name(String name) {
        validateLength(name.length());
        this.name = name;
    }

    private void validateLength(int length) {
        if (length < MIN_NAME_SIZE || length > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_SIZE);
        }
    }

    public String getName() {
        return this.name;
    }
}
