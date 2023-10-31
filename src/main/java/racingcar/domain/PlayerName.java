package racingcar.domain;

import static racingcar.domain.Constant.MAXIMUM_PLAYER_NAME_LENGTH;
import static racingcar.domain.ErrorMessage.PLAYER_NAME_LENGTH_IS_INVALID;

public class PlayerName {

    private final String value;

    public PlayerName(final String value) {
        this.value = value;
    }

    public static PlayerName from(final String playerName) {
        validateLength(playerName);
        return new PlayerName(playerName);
    }

    private static void validateLength(final String rawName) {
        if (isLengthOverFive(rawName)) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_IS_INVALID);
        }
    }

    private static boolean isLengthOverFive(final String rawName) {
        return rawName.length() > MAXIMUM_PLAYER_NAME_LENGTH;
    }

    public String getValue() {
        return value;
    }
}
