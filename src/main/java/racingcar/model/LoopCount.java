package racingcar.model;

import static racingcar.error.ErrorMessage.INVALID_LOOP_COUNT;
import static racingcar.error.ErrorMessage.NEGATIVE_LOOP_COUNT;

public class LoopCount {

    private final int value;

    private LoopCount(final String value) {
        int convertedValue = convertToInt(value);
        validate(convertedValue);

        this.value = convertedValue;
    }

    public static LoopCount of(String value) {
        return new LoopCount(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(final int convertedValue) {
        if (convertedValue < 0) {
            throw new IllegalArgumentException(NEGATIVE_LOOP_COUNT.getMessage());
        }
    }

    private int convertToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOOP_COUNT.getMessage());
        }
    }
}
