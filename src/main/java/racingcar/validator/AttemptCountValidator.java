package racingcar.validator;

import racingcar.Constants;
import racingcar.ExceptionMessage;

public enum AttemptCountValidator {
    INSTANCE;

    public void validate(String input) {
        checkAttemptCountIsInteger(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOTINTEGER.message());
        }
    }

    private boolean isNotInteger(String input) {
        return !Constants.INTEGER.matcher(input).matches();
    }
}
