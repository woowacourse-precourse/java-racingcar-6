package racingcar.util;

import static racingcar.domain.Constant.NUMBER_FORMAT;
import static racingcar.domain.Constant.PLAYER_NAMES_FORMAT;
import static racingcar.domain.ErrorMessage.PLAYER_NAMES_IS_INVALID_FORMAT;
import static racingcar.domain.ErrorMessage.RACE_COUNT_IS_NOT_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern PLAYER_NAMES_PATTERN = Pattern.compile(PLAYER_NAMES_FORMAT);
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_FORMAT);

    public static void validatePlayerNames(String rawName) {
        if (!isNamesFormat(rawName)) {
            throw new IllegalArgumentException(PLAYER_NAMES_IS_INVALID_FORMAT);
        }
    }

    public static boolean isNamesFormat(String rawNames) {
        Matcher matcher = PLAYER_NAMES_PATTERN.matcher(rawNames);
        return matcher.matches();
    }

    public static void validateRaceCount(String count) {
        if (!isNumber(count)) {
            throw new IllegalArgumentException(RACE_COUNT_IS_NOT_NUMBER);
        }
    }

    public static boolean isNumber(String count) {
        Matcher matcher = NUMBER_PATTERN.matcher(count);
        return matcher.matches();
    }
}
