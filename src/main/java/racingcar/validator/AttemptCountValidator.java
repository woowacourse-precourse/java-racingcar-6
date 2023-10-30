package racingcar.validator;

import racingcar.constants.Constants;
import racingcar.constants.ExceptionMessage;

public enum AttemptCountValidator {
    INSTANCE;

    public void validate(String input) {
        checkAttemptCountIsInteger(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_INTEGER.message());
        }
    }

    private boolean isNotInteger(String input) {
        return !Constants.INTEGER.matcher(input).matches();
    }
}
