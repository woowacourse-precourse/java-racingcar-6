package racingcar;

import static racingcar.Constant.MAXIMUM_PLAYER_NAME_LENGTH;
import static racingcar.Constant.PLAYER_NAMES_DELIMITER;
import static racingcar.Constant.PLAYER_NAMES_FORMAT;
import static racingcar.ErrorMessage.PLAYER_NAMES_IS_INVALID_FORMAT;
import static racingcar.ErrorMessage.PLAYER_NAME_LENGTH_IS_INVALID;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerName {

    private static final Pattern PLAYER_NAMES_PATTERN = Pattern.compile(PLAYER_NAMES_FORMAT);
    private final String playerName;

    public PlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static PlayerName from(String playerName) {
        validateLength(playerName);
        return new PlayerName(playerName);
    }

    private static void validateLength(String rawName) {
        if (isLengthOverFive(rawName)) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_IS_INVALID);
        }
    }

    private static boolean isLengthOverFive(String rawName) {
        return rawName.length() > MAXIMUM_PLAYER_NAME_LENGTH;
    }

    private static void validateFormat(String rawName) {
        if (!isNamesFormat(rawName)) {
            throw new IllegalArgumentException(PLAYER_NAMES_IS_INVALID_FORMAT);
        }
    }

    private static boolean isNamesFormat(String rawNames) {
        Matcher matcher = PLAYER_NAMES_PATTERN.matcher(rawNames);
        return matcher.matches();
    }

    private static List<String> convertNames(String rawNames) {
        return Arrays.asList(rawNames.split(PLAYER_NAMES_DELIMITER));
    }
}
