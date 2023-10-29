package racingcar.domain;

import java.util.List;

public class RacingGameStatus {
    private final List<RaceStatus> raceStatuses;

    public RacingGameStatus(List<RaceStatus> raceStatuses) {
        this.raceStatuses = raceStatuses;
    }
}
