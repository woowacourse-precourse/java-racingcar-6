package racingcar.util;

import java.util.List;

public class Validator {
    private static final Validator instance = new Validator();

    public static Validator getInstance() {
        return instance;
    }

    public void validateCarName(List<String> inputs) {
        checkCarCount(inputs);
        checkNameLength(inputs);
    }

    private void checkNameLength(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    private void checkCarCount(List<String> inputs) {
        if (inputs.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT.getMessage());
        }
    }

    public void validateAttemptCount(int input) {
        checkCountRange(input);
    }

    private void checkCountRange(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT_RANGE.getMessage());
        }
    }
}
