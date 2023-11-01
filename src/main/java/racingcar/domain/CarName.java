package racingcar.domain;

import racingcar.message.ErrorMessage;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateBlank(name);
        validateNameLength(name);
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }
    public String getName() {
        return name;
    }
}
