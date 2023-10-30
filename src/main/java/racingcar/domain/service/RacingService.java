package racingcar.domain.service;

import racingcar.domain.RacingCarManager;

public class RacingService {

	public void startRacing(RacingCarManager racingCarManager) {
		while (racingCarManager.isNotGameEnd()) {
			racingCarManager.getRacingCarList().moveOrStop();
			racingCarManager.getRacingCarList().outputResult();
			racingCarManager.decreaseNumberOfAttempt();
		}
	}
}
