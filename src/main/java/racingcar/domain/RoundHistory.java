package racingcar.domain;

import java.util.Map;

public record RoundHistory(
        NumberOfRound currentRound,
        Map<Name, Distance> roundResult
) {
}
