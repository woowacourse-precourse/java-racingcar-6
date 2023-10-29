package racingcar.controller.dto;

import racingcar.domain.car.RaceCars;

public class RaceGameInfo {
    private final RaceCars raceCars;
    private final int attemptCount;

    public RaceGameInfo(RaceCars raceCars, int attemptCount) {
        this.raceCars = raceCars;
        this.attemptCount = attemptCount;
    }

    public RaceCars getRaceCars() {
        return raceCars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
