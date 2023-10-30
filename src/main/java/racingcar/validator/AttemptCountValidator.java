package racingcar.validator;

import static racingcar.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;
import static racingcar.config.InputPattern.ATTEMPT_COUNT_REGEX;

public class AttemptCountValidator implements Validator<Integer> {
    public Integer validate(Integer attemptCount) {
        String regex = ATTEMPT_COUNT_REGEX.getRegex();
        String message = ATTEMPT_COUNT_ERROR_MESSAGE.getMessage();

        if (!attemptCount.toString().matches(regex)) {
            throw new IllegalArgumentException(message);
        }
        return attemptCount;
    }
}
