package racingcar.validator;

import racingcar.constants.Constants;
import racingcar.constants.ExceptionMessage;
import racingcar.dto.AttemptCount;

public enum AttemptCountValidator {
    INSTANCE;

    public AttemptCount validate(String input) {
        checkAttemptCountIsInteger(input);

        return createAttemptCount(input);
    }

    private void checkAttemptCountIsInteger(String input) {
        if (isNotInteger(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_INTEGER.message());
        }
    }

    private boolean isNotInteger(String input) {
        return !Constants.INTEGER.matcher(input).matches();
    }

    private AttemptCount createAttemptCount(String input) {
        return new AttemptCount(toInt(input));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
