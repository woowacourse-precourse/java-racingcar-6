package racingcar.util;

import static racingcar.domain.Constant.PLAYER_NAMES_DELIMITER;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.domain.RaceCount;
import racingcar.dto.PlayerNamesDto;

public class InputConvertor {
    public static PlayerNamesDto convertPlayerNames(final String rawPlayerNames) {
        List<String> playerNames = splitPlayerNames(rawPlayerNames);
        return PlayerNamesDto.from(Collections.unmodifiableList(playerNames));
    }

    private static List<String> splitPlayerNames(final String rawPlayerNames) {
        return Arrays.asList(rawPlayerNames.split(PLAYER_NAMES_DELIMITER));
    }

    public static RaceCount convertRaceCount(final String rawRaceCount) {
        int raceCount = Integer.parseInt(rawRaceCount);
        return RaceCount.from(raceCount);
    }
}
