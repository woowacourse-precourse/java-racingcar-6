package racingcar.domain;

import static racingcar.message.ErrorMessage.NEGATIVE_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.message.ErrorMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE;
import static racingcar.message.MessageConstants.ZERO;

public class TryCount {
    private final int value;

    public TryCount(String inputTryCount) {
        int intTryCount = validateNumberFormat(inputTryCount);
        validateNegativeNumber(intTryCount);
        this.value = intTryCount;
    }

    private int validateNumberFormat(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private void validateNegativeNumber(int parseTryCount) {
        if (parseTryCount < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
