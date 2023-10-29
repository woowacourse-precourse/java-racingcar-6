package racingcar.model;

import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MovingCount {
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final Pattern IS_NUMBER = Pattern.compile(NUMBER_REGEX);

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
            throw new IllegalArgumentException(EXCEEDED_LIMIT_CAR_LENGTH.getMessage());
        }
    }

    public boolean isNotEqual(int i) {
        return count != i;
    }
}
