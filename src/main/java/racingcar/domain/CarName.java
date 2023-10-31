package racingcar.domain;

import racingcar.constants.ExceptionMessages;

public record CarName(String name) {

    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;

    public CarName {
        validateName(name);
    }

    private void validateName(final String name) {
        validateCarNameIsBlank(name);
        validateLengthCarName(name);
    }

    private void validateCarNameIsBlank(final String name) {
        if (name == null || name.trim().isEmpty()) {
            ExceptionMessages.NONE_INPUT_CARS.throwException();
        }
    }

    private void validateLengthCarName(final String name) {
        if (name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            ExceptionMessages.CAR_NAME_LIMIT_EXCEEDED.throwException();
        }
    }
}
