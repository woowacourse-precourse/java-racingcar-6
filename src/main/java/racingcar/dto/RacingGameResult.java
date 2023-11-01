package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private final List<RaceStatus> raceStatuses;
    private final WinnerNames winnerNames;

    public RacingGameResult(List<RaceStatus> raceStatuses, WinnerNames winnerNames) {
        this.raceStatuses = raceStatuses;
        this.winnerNames = winnerNames;
    }

    public List<RaceStatus> getRaceStatuses() {
        return Collections.unmodifiableList(raceStatuses);
    }

    public WinnerNames getWinnerNames() {
        return winnerNames;
    }
}
