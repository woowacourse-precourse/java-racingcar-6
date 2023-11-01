package racingcar.util;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;

public class TestContext {
    private RacingCars racingCars;
    private RacingWinners racingWinners;

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public void setRacingCars(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingWinners getRacingWinners() {
        return racingWinners;
    }

    public void setRacingWinners(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }
}
