package racingcar.model;

import racingcar.message.ErrorMessage;

public class TryCount {

    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String ZERO_REGEX = "^0$";

    private final int count;

    public TryCount(String count) {
        validateNumber(count);
        validateZero(count);
        this.count = Integer.parseInt(count);
    }

    private void validateNumber(String count) {
        if (!count.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_ONLY_NUMBER);
        }
    }

    private void validateZero(String count) {
        if (count.matches(ZERO_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_POSITIVE_NUMBER_RANGE);
        }
    }

    public int value() {
        return count;
    }
}