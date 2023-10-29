package racingcar;

import static racingcar.Constant.MINIMUM_RACE_COUNT;
import static racingcar.Constant.NUMBER_FORMAT;
import static racingcar.ErrorMessage.RACE_COUNT_IS_NOT_IN_RANGE;
import static racingcar.ErrorMessage.RACE_COUNT_IS_NOT_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaceCount {

    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_FORMAT);
    private final int value;

    public RaceCount(int count) {
        this.value = count;
    }

    public static RaceCount from(String rawCount) {
        int count = validateAndConvert(rawCount);
        return new RaceCount(count);
    }

    private static int validateAndConvert(String rawCount) {
        validateNumber(rawCount);
        int count = Integer.parseInt(rawCount);
        validateRange(count);
        return count;
    }

    private static void validateNumber(String count) {
        if (!isNumber(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_NUMBER);
        }
    }

    private static boolean isNumber(String count) {
        Matcher matcher = NUMBER_PATTERN.matcher(count);
        return matcher.matches();
    }

    private static void validateRange(int count) {
        if (!isInRange(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_IN_RANGE);
        }
    }

    private static boolean isInRange(int count) {
        return count >= MINIMUM_RACE_COUNT;
    }
}
