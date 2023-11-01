package racingcar.domain;

import racingcar.exception.ExceptionMessages;

public class TryCountValidator {
    public final int tryCount;

    public TryCountValidator(String input) {
        tryCount = convertStringToInt(input);
        validateNumber(tryCount);
    }

    private void validateNumber(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_NATURAL_TRY_COUNT);
        }
    }

    private int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_NUMBER_TRY_COUNT);
        }
    }
}
