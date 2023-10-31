package racingcar.validator;

import static racingcar.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;
import static racingcar.config.InputPattern.ATTEMPT_COUNT_REGEX;

import java.util.regex.Pattern;

public class AttemptCountValidator implements Validator<Integer> {
    private static final Pattern ATTEMPT_COUNT_PATTERN =
            Pattern.compile(ATTEMPT_COUNT_REGEX.getRegex());

    public Integer validate(Integer attemptCount) {
        String message = ATTEMPT_COUNT_ERROR_MESSAGE.getMessage();

        if (!ATTEMPT_COUNT_PATTERN.matcher(attemptCount.toString()).matches()) {
            throw new IllegalArgumentException(message);
        }
        return attemptCount;
    }
}
