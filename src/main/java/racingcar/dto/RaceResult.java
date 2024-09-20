package racingcar.dto;

import java.util.List;

public record RaceResult(
        int raceRoundCount,
        List<CarStatus> carStatuses
) {
}
