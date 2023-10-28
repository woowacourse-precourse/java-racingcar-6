package racingcar.domain;

import racingcar.util.ErrorMessage;

public class Car {

    private final String name;

    public Car(String name) {
        validateNameLength(name);
        validateNameNoWhitespace(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH.getMessage());
        }
    }

    private void validateNameNoWhitespace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NO_WHITESPACE.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }
}
