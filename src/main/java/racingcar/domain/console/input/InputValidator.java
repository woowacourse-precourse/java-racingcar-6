package racingcar.domain.console.input;

import racingcar.exception.RacingCarException;

public class InputValidator {
    private final static int MAX_LENGTH = 6;
    private final static int MIN_ATTEMPT_COUNT = 1;

    private InputValidator() {
    }

    public static InputValidator newInstance() {
        return new InputValidator();
    }

    public void validateNameLength(final String name) throws IllegalArgumentException {
        if (name.length() >= MAX_LENGTH) {
            RacingCarException.NAME_LENGTH_EXCEPTION.getException();
        }
    }

    public void validateAttemptSize(final int count) throws IllegalArgumentException {
        if (count < MIN_ATTEMPT_COUNT) {
            RacingCarException.ATTEMPT_MINIMUM_COUNT_EXCEPTION.getException();
        }
    }

}
