package racingcar.domain.console.input;

import racingcar.exception.RacingCarException;

public class InputValidator {
    private final static int MAX_LENGTH = 6;
    private final static int MIN_ATTEMPT_COUNT = 1;
    private final static String NUMBER_REGEX = "^[0-9]+$";

    private InputValidator() {
    }

    public static InputValidator newInstance() {
        return new InputValidator();
    }

    public void validateNameLength(final String inputName) throws IllegalArgumentException {
        if (inputName.length() >= MAX_LENGTH) {
            RacingCarException.NAME_LENGTH_EXCEPTION.getException();
        }
    }

    public void validateAttemptSize(final int inputCount) throws IllegalArgumentException {
        if (inputCount < MIN_ATTEMPT_COUNT) {
            RacingCarException.ATTEMPT_MINIMUM_COUNT_EXCEPTION.getException();
        }
    }

    public void validateNumericInput(final String inputNumber) {
        if (!inputNumber.matches(NUMBER_REGEX)) {
            RacingCarException.NUMERIC_INPUT_EXCEPTION.getException();
        }
    }

}
