package racingcar.model;

import static racingcar.util.Constant.ZERO;

import racingcar.exception.console_input.CanNotConvertToIntInputException;

public class AttemptCount {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private int attemptCount;

    public AttemptCount(final String attemptCount) {
        validateStringToInt(attemptCount);
        this.attemptCount = Integer.parseInt(attemptCount);
    }

    private void validateStringToInt(final String attemptCount) {
        if (hasNonNumericChar(attemptCount)) {
            throw new CanNotConvertToIntInputException(attemptCount);
        }
    }

    private boolean hasNonNumericChar(final String attemptCount) {
        return !attemptCount.matches(REGEXP_PATTERN_NUMBER);
    }

    public boolean isGameOver() {
        return attemptCount <= ZERO.getValue();
    }

    public void decrease() {
        attemptCount--;
    }
}
