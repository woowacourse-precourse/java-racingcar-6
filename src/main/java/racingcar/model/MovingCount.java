package racingcar.model;

import static racingcar.constant.InputError.EXCEEDED_MAXIMUM_INPUT;
import static racingcar.constant.InputError.NOT_DIGIT_MOVING_COUNT;
import static racingcar.constant.RaceConfig.IS_NUMBER;

import java.util.regex.Matcher;

public final class MovingCount {
    private final int count;

    private MovingCount(String input) {
        validateInputIsDigit(input);
        this.count = validateMoreThanMaxInteger(input);
    }

    public static MovingCount createMovingCount(String input) {
        return new MovingCount(input);
    }

    private void validateInputIsDigit(String input) {
        Matcher matcher = IS_NUMBER.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_DIGIT_MOVING_COUNT.toString());
        }
    }

    private int validateMoreThanMaxInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEEDED_MAXIMUM_INPUT.toString());
        }
    }

    public boolean isNotEqual(int i) {
        return count != i;
    }
}
