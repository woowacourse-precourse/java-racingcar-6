package racingcar.util;

import static racingcar.domain.Constant.PLAYER_NAMES_DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.PlayerNamesDto;
import racingcar.domain.RaceCount;

public class InputConvertor {
    public static PlayerNamesDto convertPlayerNames(String rawPlayerNames) {
        List<String> playerNames = Arrays.asList(rawPlayerNames.split(PLAYER_NAMES_DELIMITER));
        return PlayerNamesDto.from(playerNames);
        // unmodifiavble 필요?
    }

    public static RaceCount convertRaceCount(String rawRaceCount) {
        int raceCount = Integer.parseInt(rawRaceCount);
        return RaceCount.from(raceCount);
    }
}
