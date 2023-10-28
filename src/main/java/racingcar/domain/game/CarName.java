package racingcar.domain.game;

import racingcar.util.Err;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(String name) {
        validateCarNameMinLength(name);
        validateCarNameMaxLength(name);
    }

    private void validateCarNameMinLength(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAME_MIN_LENGTH.getMessage());
        }
    }

    private void validateCarNameMaxLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Err.INVALID_CAR_NAME_MAX_LENGTH.getMessage());
        }
    }
}
