package racingcar.model;

import static java.util.regex.Pattern.matches;
import static racingcar.util.Constant.ZERO;

import racingcar.exception.console_input.CanNotConvertToIntInputException;

public class AttemptCount {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private int attemptCount;

    public AttemptCount(final String attemptCount) {
        validateStringToInt(attemptCount);
        this.attemptCount = Integer.parseInt(attemptCount);
    }

    private static void validateStringToInt(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new CanNotConvertToIntInputException(string);
        }
    }

    public boolean isGameOver() {
        return attemptCount <= ZERO.getValue();
    }

    public void decrease() {
        attemptCount--;
    }
}
