package racingcar.domain;

import racingcar.message.Messages;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        checkValidation(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private void checkValidation(String name) {
        validateNull(name);
        validateLength(name);
    }


    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH ) {
            throw new IllegalArgumentException(Messages.EXCEED_MAX_LENGTH_NAME_MESSAGE);
        } else if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(Messages.LESS_MIN_LENGTH_NAME_MESSAGE);
        }
    }

    private void validateNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(Messages.NULL_NAME_MESSAGE);
        }
    }
}
