package racingcar.domain.service;

import racingcar.domain.RacingCarManager;
import racingcar.global.utils.generator.RandomNumberGenerator;

public class RacingService {

    public void startRacing(RacingCarManager racingCarManager) {
        while (racingCarManager.isNotGameEnd()) {
            racingCarManager.getRacingCarList().moveOrStop(new RandomNumberGenerator());
            racingCarManager.getRacingCarList().outputResult();
            racingCarManager.decreaseNumberOfAttempt();
        }
    }
}
