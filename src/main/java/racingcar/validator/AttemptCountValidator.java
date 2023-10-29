package racingcar.validator;

import racingcar.Constants;
import racingcar.ExceptionMessage;
import racingcar.dto.AttemptCount;

public enum AttemptCountValidator {
    INSTANCE;

    public AttemptCount validate(String input) {
        checkAttemptCountIsInteger(input);
        return createAttemptCount(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOTINTEGER.message());
        }
    }

    private boolean isNotInteger(String input) {
        return !Constants.INTEGER.matcher(input).matches();
    }

    private AttemptCount createAttemptCount(String input) {
        return new AttemptCount(input);
    }
}
