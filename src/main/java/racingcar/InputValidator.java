package racingcar;

import static racingcar.Constant.PLAYER_NAMES_FORMAT;
import static racingcar.ErrorMessage.PLAYER_NAMES_IS_INVALID_FORMAT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern PLAYER_NAMES_PATTERN = Pattern.compile(PLAYER_NAMES_FORMAT);

    public static void validatePlayerNames(String rawName) {
        if (!isNamesFormat(rawName)) {
            throw new IllegalArgumentException(PLAYER_NAMES_IS_INVALID_FORMAT);
        }
    }

    public static boolean isNamesFormat(String rawNames) {
        Matcher matcher = PLAYER_NAMES_PATTERN.matcher(rawNames);
        return matcher.matches();
    }
}
