package tdd.validator;

import static tdd.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;
import static tdd.config.InputPattern.ATTEMPT_COUNT_REGEX;

public class AttemptCountValidator {
    public static String validate(String attemptCount) {
        String regex = ATTEMPT_COUNT_REGEX.getRegex();
        String message = ATTEMPT_COUNT_ERROR_MESSAGE.getMessage();

        if (!attemptCount.matches(regex)) {
            throw new IllegalArgumentException(message);
        }
        return attemptCount;
    }
}
