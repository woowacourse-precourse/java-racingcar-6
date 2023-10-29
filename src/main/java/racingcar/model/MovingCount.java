package racingcar.model;

import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;
import static racingcar.constant.RaceConfig.IS_NUMBER;

import java.util.regex.Matcher;

public final class MovingCount {
    private final int count;

    private MovingCount(String input) {
        validateInputIsDigit(input);
        this.count = Integer.parseInt(input);
    }

    public static MovingCount createMovingCount(String input) {
        return new MovingCount(input);
    }

    private void validateInputIsDigit(String input) {
        Matcher matcher = IS_NUMBER.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(EXCEEDED_LIMIT_CAR_LENGTH.toString());
        }
    }

    public boolean isNotEqual(int i) {
        return count != i;
    }
}
