package racingcar.dto;

import racingcar.domain.car.RaceCars;

public class RaceGameInfoDto {
    private final RaceCars raceCars;
    private final int attemptCount;

    public RaceGameInfoDto(RaceCars raceCars, int attemptCount) {
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
