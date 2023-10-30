package racingcar;

import static racingcar.Constant.PLAYER_NAMES_DELIMITER;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {
    public static PlayerNamesDto convertPlayerNames(String rawPlayerNames) {
        List<String> playerNames = Arrays.asList(rawPlayerNames.split(PLAYER_NAMES_DELIMITER));
        return PlayerNamesDto.from(playerNames);
        // unmodifiavble 필요?
    }
}
