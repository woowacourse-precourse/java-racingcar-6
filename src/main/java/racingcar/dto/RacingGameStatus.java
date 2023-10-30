package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class RacingGameStatus {
    private final List<RaceStatus> raceStatuses;

    public RacingGameStatus(List<RaceStatus> raceStatuses) {
        this.raceStatuses = raceStatuses;
    }

    public List<RaceStatus> getRaceStatuses() {
        return Collections.unmodifiableList(raceStatuses);
    }
}
