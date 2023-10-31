package racingcar.validator;

import static racingcar.config.ErrorMessage.ATTEMPT_COUNT_ERROR_MESSAGE;
import static racingcar.config.InputPattern.ATTEMPT_COUNT_REGEX;

import java.util.regex.Pattern;
import racingcar.util.ErrorThrower;
import racingcar.util.PatternChecker;

public class AttemptCountValidator implements Validator<String> {
    private static final Pattern ATTEMPT_COUNT_PATTERN =
            Pattern.compile(ATTEMPT_COUNT_REGEX.getRegex());

    public String validate(String attemptCount) {
        String message = ATTEMPT_COUNT_ERROR_MESSAGE.getMessage();

        if (PatternChecker.checkPattern(ATTEMPT_COUNT_PATTERN, attemptCount)) {
            ErrorThrower.throwIAE(message);
        }
        return attemptCount;
    }
}
