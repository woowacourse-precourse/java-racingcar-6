package racingcar;

import static racingcar.Constant.MINIMUM_RACE_COUNT;
import static racingcar.Constant.NUMBER_FORMAT;
import static racingcar.ErrorMessage.RACE_COUNT_IS_NOT_IN_RANGE;
import static racingcar.ErrorMessage.RACE_COUNT_IS_NOT_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaceCount {

    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_FORMAT);

    public void validateNumber(String count) {
        if (!isNumber(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_NUMBER);
        }
    }

    private boolean isNumber(String count) {
        Matcher matcher = NUMBER_PATTERN.matcher(count);
        return matcher.matches();
    }

    public void validateRange(String number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_IN_RANGE);
        }
    }

    private boolean isInRange(String number) {
        return Integer.parseInt(number) >= MINIMUM_RACE_COUNT;
    }
}
