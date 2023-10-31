package racingcar.validator;

import static racingcar.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;
import static racingcar.config.InputPattern.ATTEMPT_COUNT_REGEX;

import java.util.regex.Pattern;
import racingcar.util.ErrorThrower;
import racingcar.util.PatternChecker;

public class AttemptCountValidator implements Validator<Integer> {
    private static final Pattern ATTEMPT_COUNT_PATTERN =
            Pattern.compile(ATTEMPT_COUNT_REGEX.getRegex());

    public Integer validate(Integer attemptCount) {
        String message = ATTEMPT_COUNT_ERROR_MESSAGE.getMessage();

        if (PatternChecker.checkPattern(ATTEMPT_COUNT_PATTERN, attemptCount.toString())) {
            ErrorThrower.throwIAE(message);
        }
        return attemptCount;
    }
}
